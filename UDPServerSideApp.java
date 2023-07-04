import java.io.IOException;
import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import serverside.SentenceProcessor;

/**
 * Client-side application using UDP Part2 Exercise2
 * 
 * 
 * @author raszreen
 *
 */

@SuppressWarnings("unused")
public class UDPServerSideApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		System.out.println("UDPServerSideApp: Demonstration of UDP Server-Side "
				+ "Application.");
		
		
		// Permissible port for this application
		int portNo = 8083;
        
        try {
        	
    		// 1. Bind a DatagramSocket's object to a port number
            DatagramSocket datagramSocket = new DatagramSocket(portNo);
        	
            // Continually listen for request
        	while (true) {
                
                // 2. Variable to received data from the port
        		// 65535 is the maximum size for UDP packet
                byte[] receivedData = new byte[65535];
          
                // 3. Object represents packet from client
                DatagramPacket receivedPacket = 
                		new DatagramPacket(receivedData, receivedData.length);
                
                // 4. Receive packet
				datagramSocket.receive(receivedPacket);
				
				// 5. Extract data from packet
				receivedData = receivedPacket.getData();
				
				// 6. Further processing
				SentenceProcessor processor = 
						new SentenceProcessor(receivedData);
				String sentence = processor.getSentence();
				System.out.println("\nMessage received: " + sentence + ".\n");
				
				// This is not used because it give a misleading result
	            // int length = sentence.length();
	            
	            // More processing
	            int totalCharacters =  processor.countCharacters();
	            byte[] outData = processor.convertToByteArray(totalCharacters);
	            
	            int totalPunctions =  processor.countPunctions();
	            byte[] outData1 = processor.convertToByteArray(totalPunctions);
	            
	            int totalVowels =  processor.countVowels();
	            byte[] outData2 = processor.convertToByteArray(totalVowels);
	            
	            int totalConstants =  processor.countConstants();
	            byte[] outData3 = processor.convertToByteArray(totalConstants);
	            
	            // 7. Get the client information
	            InetAddress clientAddress =  receivedPacket.getAddress();
	            int clientPort = receivedPacket.getPort();
	            int sizeOutData = outData.length;
	            int sizeOutData1 = outData1.length;
	            int sizeOutData2 = outData2.length;
	            int sizeOutData3 = outData3.length;
	            
	            // 8. Wrap data into datagram packet
	            DatagramPacket outPacket = new DatagramPacket(outData, 
	            		sizeOutData,  clientAddress, clientPort);
	            
	            DatagramPacket outPacket1 = new DatagramPacket(outData1, 
	            		sizeOutData1,  clientAddress, clientPort);
	            
	            DatagramPacket outPacket2 = new DatagramPacket(outData2, 
	            		sizeOutData2,  clientAddress, clientPort);
	            
	            DatagramPacket outPacket3 = new DatagramPacket(outData3, 
	            		sizeOutData3,  clientAddress, clientPort);
	            
	            // 9. Reply to client
	            datagramSocket.send(outPacket);
	            System.out.println("Message sent (totalCharacters) : " 
	            		+ totalCharacters  + ".\n");
	            
	            datagramSocket.send(outPacket1);
	            System.out.println("Message sent (totalPunctions) : " 
	            		+ totalPunctions  + ".\n");
	            
	            datagramSocket.send(outPacket2);
	            System.out.println("Message sent (totalVowels) : " 
	            		+ totalVowels  + ".\n");
	            
	            datagramSocket.send(outPacket3);
	            System.out.println("Message sent (totalConstants) : " 
	            		+ totalConstants  + ".\n");
	            
        	}
				
		} catch (IOException e) {
				
			e.printStackTrace();
        }
        
        System.out.println("UDPClientSideApp: End of program.");
    }
}
