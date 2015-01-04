package OnlineServers.Inheritable;

import CurrentDb.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InheritableServer implements Runnable {

    protected static Scanner _scanner = new Scanner(System.in);
    protected int _serverRefershAfterHits;
    protected int _serverHitCounter = 0;



    public Thread _serverThread;

    protected boolean _isActive = false;
    protected boolean _shouldThreadRun = false;

    public InheritableServer() {
        this._serverRefershAfterHits = 100;
        initalizeQuery();

    }


    /**
     * checks if not null and alive
     *
     * @param server
     * @return
     */
    @SuppressWarnings("deprecation")
    protected Thread stopThread(InheritableServer server) {
        if (_serverThread == null) {
            _serverThread = new Thread(server);
        }
        if (_serverThread.isAlive()) {
            _shouldThreadRun = false;
            _serverThread.interrupt();
            _serverThread.stop();

            System.out.println("Server stopped.");

        } else {
            System.out.println("Sorry thread is not running can't stop. Already in stop mode.");
        }
        return _serverThread;
    }

    /**
     * checks if not null and alive
     *
     * @param server
     * @return
     */
    protected Thread startThread(InheritableServer server) {
        if (_serverThread == null) {
            _serverThread = new Thread(server);
        }
        if (!_serverThread.isAlive()) {
            _shouldThreadRun = true;
            _serverThread.start();
     
            System.out.println("Server started.");
        } else {
            System.out.println("Thread is already running.");

        }
        return _serverThread;
    }

    private void initalizeQuery() {
//        db = new DatabaseQuery();
//        // setting table name
//        db.setTableName(TableNames.SERVERSETTING);

        //refeshes port and is active state
        reReadDataFromServer();
    }

    /**
     * Refreshing Server ResultSet refresh port
     *
     */
    public void reReadDataFromServer() {
        // executing the db

    }

    /**
     * Output to the server
     *
     * @param socket
     * @return
     */
    public DataOutputStream getDataOutputObjectStream(Socket socket) {
        DataOutputStream reader = null;
        try {
            reader = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(InheritableServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reader;
    }

    /**
     * Output to the server
     *
     * @param socket
     * @return
     */
    public ObjectOutputStream getOutputObjectStream(Socket socket) {
        ObjectOutputStream reader = null;
        try {
            reader = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(InheritableServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reader;
    }

    /**
     * Getting input from modified things from server.
     *
     * @param socket
     * @return
     */
    public ObjectInputStream getObjectInputStream(Socket socket) {
        ObjectInputStream reader = null;
        try {
            reader = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(InheritableServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reader;
    }

    /**
     * Getting input from modified things from server.
     *
     * @param socket
     * @return
     */
    public BufferedReader getBufferedReader(Socket socket) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(InheritableServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reader;
    }

    /**
     * Taking client input from console.
     *
     * @return
     */
    public BufferedReader getBufferedReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader;
    }

    public static void main(String[] args) {
        Thread server = new Thread(new InheritableServer());
        server.start();
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
