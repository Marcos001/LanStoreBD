package com.CraftSoft.MV.Socket;

/**
 * Created by nig on 23/01/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.CraftSoft.MV.DATABASE.*;


public class Servidor extends JPanel {

    /**------------------------- Variáveis ----------------------*/

    private JTextField enterField;        /**-- insere a mensagem do usuário         --*/
    private JTextArea displayArea;           /**-- exibe informações para o usuário     --*/
    private JScrollPane scroll;

    private ObjectOutputStream output;    /**-- gera o fluxo de saida para o cliente --*/
    private ObjectInputStream input;      /**-- gera o fluxo de entrada a aprtir do cliente --*/

    private ServerSocket server;          /**-- socket de servidor --*/
    private Socket connection;               /**-- conexão com o cliente --*/

    private int counter = 1;              /**-- contador do númedo de conexões --*/



    /**-----------INSTACIA PARA O BANCO DE DADOS MYSQL-----------------*/
    DataBase db;
    /**-----------------------------------------------------------------*/


    private void print(String m){
        System.out.println(m);
    }


    /**------------------------ Funcoes -----------------------*/
    // set up GUI
    public Servidor()
    {

        enterField = new JTextField(); // create enterField
        enterField.setEditable( false );
        enterField.addActionListener(
                new ActionListener()
                {
                    // send message to client -  press enter
                    public void actionPerformed( ActionEvent event )
                    {
                        sendData( event.getActionCommand() );
                        enterField.setText( "" );
                    } // end method actionPerformed
                } // end anonymous inner class
        ); // end call to addActionListener


        displayArea = new JTextArea(); // create displayArea
        scroll = new JScrollPane(displayArea);

        enterField.setBounds(0,0,300,30);
        scroll.setBounds(0,32,300,118);


        this.add(scroll);
        this.add(enterField);

        this.setLayout(null);
        this.setBounds(4,50,300,150);


    } // end Server constructor




    // set up and run server
    public void runServer()
    {
        try // set up server to receive connections; process connections
        {
            server = new ServerSocket( 12345, 100 ); // create ServerSocket

            while ( true )
            {
                try
                {
                    waitForConnection(); // wait for a connection
                    getStreams(); // get input & output streams
                    processConnection(); // process connection
                } // end try
                catch ( EOFException eofException )
                {
                    displayMessage( "\nServer terminated connection" );
                } // end catch
                finally
                {
                    closeConnection(); //  close connection
                    counter++;
                } // end finally
            } // end while
        } // end try
        catch ( IOException ioException )
        {
            ioException.printStackTrace();
        } // end catch
    } // end method runServer





    // wait for connection to arrive, then display connection info
    private void waitForConnection() throws IOException
    {
        displayMessage( "Waiting for connection\n" );
        connection = server.accept(); // allow server to accept connection
        displayMessage( "Connection " + counter + " received from: " +
                connection.getInetAddress().getHostName() );
    } // end method waitForConnection




    // get streams to send and receive data
    private void getStreams() throws IOException
    {
        // set up output stream for objects
        output = new ObjectOutputStream( connection.getOutputStream() );
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream( connection.getInputStream() );

        displayMessage( "\nGot I/O streams\n" );
    } // end method getStreams





    // process connection with client
    private void processConnection() throws IOException
    {
        String message = "Connection successful";
        sendData( message ); // send connection successful message

        // enable enterField so server user can send messages
        setTextFieldEditable( true );

        do // process messages sent from client
        {
            try // read message and display it
            {
                message = ( String ) input.readObject(); // read new message

                print("Menssagem recebida do cliente menssage = " + message);

                db = new DataBase(message);

                displayMessage( "\n" + message ); // display message
            } // end try
            catch ( ClassNotFoundException classNotFoundException )
            {
                displayMessage( "\nUnknown object type received" );
            } // end catch

        } while ( !message.equals( "CLIENT>>> TERMINATE" ) );
    } // end method processConnection




    // close streams and socket
    private void closeConnection()
    {
        displayMessage( "\nTerminating connection\n" );
        setTextFieldEditable( false ); // disable enterField

        try
        {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        } // end try
        catch ( IOException ioException )
        {
            ioException.printStackTrace();
        } // end catch
    } // end method closeConnection




    // send message to client
    private void sendData( String message )
    {
        try // send object to client
        {
            output.writeObject( "SERVER>>> " + message );
            output.flush(); // flush output to client
            displayMessage( "\nSERVER>>> " + message );
        } // end try
        catch ( IOException ioException )
        {
            displayArea.append( "\nError writing object" );
        } // end catch
    } // end method sendData



    // manipulates displayArea in the event-dispatch thread
    private void displayMessage( final String messageToDisplay )
    {
        SwingUtilities.invokeLater(
                new Runnable()
                {
                    public void run() // updates displayArea
                    {
                        displayArea.append( messageToDisplay ); // append message
                    } // end method run
                } // end anonymous inner class
        ); // end call to SwingUtilities.invokeLater
    } // end method displayMessage



    // manipulates enterField in the event-dispatch thread
    private void setTextFieldEditable( final boolean editable )
    {
        SwingUtilities.invokeLater(
                new Runnable()
                {
                    public void run() // sets enterField's editability
                    {
                        enterField.setEditable( editable );
                    } // end method run
                }  // end inner class
        ); // end call to SwingUtilities.invokeLater
    } // end method setTextFieldEditable


    }





