package kr.ac.itschool.dbpool;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;


public class DBConnectionManager {
	
	private Vector connections = new Vector(10);
	private String _driver = "oracle.jdbc.driver.OracleDriver";
	private String _user = "java";
    private String _url = "jdbc:oracle:thin:@localhost:1521:orcl";    
    private String _password = "1234";
    
    private boolean _traceOn = false;
    private boolean initialized = false;
    private int _openConnections = 1000;
    private static DBConnectionManager instance = null;
    
    public static DBConnectionManager getInstance() {
        if (instance == null) 
        {
            synchronized (DBConnectionManager.class) 
            {
                if (instance == null)
                {
                    instance = new DBConnectionManager();
                }
            }
        }
        return instance;
    }
    
    public void setOpenConnectionCount(int count) {
        _openConnections = count;
    }

    public void setEnableTrace(boolean enable) {
        _traceOn = enable;
    }
    
    /** Returns a Vector of java.sql.Connection objects */
    public Vector getConnectionList() {
        return connections;
    }

    /** Opens specified "count" of connections and adds them to the existing pool */
    public synchronized void setInitOpenConnections(int count) throws SQLException {
        Connection c = null;
        ConnectionObject co = null;

        for (int i = 0; i < count; i++) 
        {
            c = createConnection();
            co = new ConnectionObject(c, false);

            connections.addElement(co);
        }
    }
    
    /** Returns a count of open connections */
    public int getConnectionCount() {
        return connections.size();
    }
    
    /** Returns an unused existing or new connection.  */
    public synchronized Connection getConnection() throws Exception 
    {
        if (!initialized) 
        {
            DriverManager.registerDriver((Driver)Class.forName(_driver).newInstance()); 
            initialized = true;
        }


        Connection c = null;
        ConnectionObject co = null;
        boolean badConnection = false;


        for (int i = 0; i < connections.size(); i++) 
        {
            co = (ConnectionObject) connections.elementAt(i);

            // If connection is not in use, test to ensure it's still valid!
            if (!co.inUse) 
            {
                try 
                {
                    badConnection = co.connection.isClosed();
                    if (!badConnection)
                        badConnection = (co.connection.getWarnings() != null);
                } 
                catch (Exception e) 
                {
                    badConnection = true;
                    e.printStackTrace();
                }

                // Connection is bad, remove from pool
                if (badConnection) 
                {
                    connections.removeElementAt(i);
                    continue;
                }

                c = (Connection) co.connection;
                co.inUse = true;

                break;
            }
        }

        if (c == null) {
            c = createConnection();
            co = new ConnectionObject(c, true);
//            connections.addElement(co);
        }

        return c;
    }
    
    /** Marks a flag in the ConnectionObject to indicate this connection is no longer in use */
    public synchronized void freeConnection(Connection c) 
    {
        if (c == null)
            return;

        ConnectionObject co = null;

        for (int i = 0; i < connections.size(); i++) 
        {
            co = (ConnectionObject) connections.elementAt(i);
            if (c == co.connection) 
            {
                co.inUse = false;
                break;
            }
        }

        for (int i = 0; i < connections.size(); i++) 
        {
            co = (ConnectionObject) connections.elementAt(i);
            if ((i + 1) > _openConnections && !co.inUse)
                removeConnection((Connection) co.connection);
        }
    }

    public void freeConnection(Connection c, PreparedStatement p, ResultSet r)
    {
        try 
        {
            if (r != null) r.close();
            if (p != null) p.close();
            freeConnection(c);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, Statement s, ResultSet r) 
    {
        try 
        {
            if (r != null) r.close();
            if (s != null) s.close();
            freeConnection(c);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, PreparedStatement p) {
        try {
            if (p != null) p.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, Statement s) {
        try {
            if (s != null) s.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /** Marks a flag in the ConnectionObject to indicate this connection is no longer in use */
    public synchronized void removeConnection(Connection c) {
        if (c == null)
            return;

        ConnectionObject co = null;
        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.elementAt(i);
            if (c == co.connection) {
                try {
                    c.close();
                    connections.removeElementAt(i);
                    trace("Removed " + c.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            }
        }
    }


    private Connection createConnection()
            throws SQLException {
        Connection con = null;

        try {
            if (_user == null)
                _user = "";
            if (_password == null)
                _password = "";

            Properties props = new Properties();
            props.put("user", _user);
            props.put("password", _password);

            con = (Connection) DriverManager.getConnection(_url, props);
        } catch (Throwable t) {
            throw new SQLException(t.getMessage());
        }

        return con;
    }


    /** Closes all connections and clears out the connection pool */
    public void releaseFreeConnections() {
        trace("ConnectionPoolManager.releaseFreeConnections()");

        Connection c = null;
        ConnectionObject co = null;

        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.elementAt(i);
            if (!co.inUse)
                removeConnection((Connection) co.connection);
        }
    }


    /** Closes all connections and clears out the connection pool */
    public void finalize() {
        trace("ConnectionPoolManager.finalize()");

        Connection c = null;
        ConnectionObject co = null;

        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.elementAt(i);
            try {
                co.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            co = null;
        }

        connections.removeAllElements();
    }


    private void trace(String s) {
        if (_traceOn)
            System.err.println(s);
    }

}

class ConnectionObject {
    public java.sql.Connection connection = null;
    public boolean inUse = false;

    public ConnectionObject(Connection c, boolean useFlag) {
        connection = c;
        inUse = useFlag;
    }
}
    