package net.danielmelcer.cheekers.network;

import java.net.*;
import javax.xml.bind.DatatypeConverter;

/**
 * Converts an IP address to and from User-Friendly String
 * @author Daniel Melcer
 *
 */
public class IPEncoder {
	
	private final String strRepresentation;
	private final InetAddress address;
	
	/**
	 * Constructs an IPEncoder with an IP address
	 * @param address The address to encode
	 */
	public IPEncoder(InetAddress address){
		this.address= address;
		byte[] adBytes = address.getAddress();
		this.strRepresentation= DatatypeConverter.printHexBinary(adBytes);
	}
	
	/**
	 * Constructs an IPEncoder with an encoded IP address
	 * @param string The Encoded String
	 * @throws InvalidIDException If the String does not encode a valid IP address
	 */
	public IPEncoder(String string) throws InvalidIDException{
		this.strRepresentation = string.toUpperCase();
		try{
			byte[] adBytes= DatatypeConverter.parseHexBinary(string);
			this.address = InetAddress.getByAddress(adBytes);
		} catch (UnknownHostException|IllegalArgumentException e){
			throw new InvalidIDException("An invalid ID has been entered. The ID should be 8 characters, either numbers or letters A-F.");
		}
	}
	
	/**
	 * Tests equality of two IPEncoders
	 * @param encoder The other IPEncoder
	 * @return true if the two encoders are equal
	 */
	public boolean equals(IPEncoder encoder){
		return this.getStrRepresentation().equals(encoder.getStrRepresentation());
	}
	
	/**
	 * Gets the String representation of an IP address
	 * @return The String version of an IP address
	 */
	public String getStrRepresentation(){
		return strRepresentation;
	}
	
	/**
	 * Gets the IP address corresponding to the IPEncoder
	 * @return The IP address represented by the encoder
	 */
	public InetAddress getAddress(){
		return address;
	}
	
	/**
	 * This exception represents an invalidly formed IP string
	 * @author Daniel Melcer
	 *
	 */
	public class InvalidIDException extends Exception{
		/**
		 * 
		 */
		private static final long serialVersionUID = -2959304652399881190L;

		private InvalidIDException(String message){
			super(message);
		}
	}
	
}
