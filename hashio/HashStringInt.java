package es.urjc.ist.hashio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import es.urjc.ist.hash.Hash;

/**
 * 
 * Hash table with string keys and integer values.
 * Significan methods:
 * 		-writeTo: Writes on a given file.
 * 		-readFrom: Reads from a given file and makes a new table out of it.
 * 
 * The pattern used for writting is:
 * 		Number of nodes(4 bytes) Key length(4 bytes) 
 * 		Key(Key length bytes) Value(4 bytes)
 * @author jperalta
 *
 */

public class HashStringInt extends Hash<String, Integer>{
	
	
	public HashStringInt(){ 
		super();
	}
	
	public void writeTo(OutputStream os){
		DataOutputStream out = new DataOutputStream(os);
		String key;
		int val;
		byte[] b;
				
		try {
			out.writeInt(length());
			Iterator<String> itHash = iterator();
			while(itHash.hasNext()){
				key = itHash.next();
				if(key != null){
					b = key.getBytes();
					out.writeInt(b.length);
					out.write(b,0,b.length);
					val = get(key);
					out.writeInt(val);
				}
			}
			os.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void writeTo(String file){
		try {
			OutputStream fd = new FileOutputStream(file);
			writeTo(fd);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static HashStringInt readFrom(InputStream is) {
		HashStringInt data = new HashStringInt();
		DataInputStream in = new DataInputStream(is);
		byte[] buf = new byte[265];
		int keylen;
		int nodesnum = 0;
		int value;
		String key;
		
		try {
			nodesnum = in.readInt();
			for(int i = 0; i < nodesnum; i++){
				keylen = in.readInt();
				in.readFully(buf, 0, keylen);
				key = new String(buf, 0, keylen);
				value = in.readInt();
				data.put(key, value);
			}
			is.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return data;
	}

	public static HashStringInt readFrom(String file) {
		HashStringInt data = null;
		
		try {
			InputStream fd = new FileInputStream(file);
			data = readFrom(fd);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return data;
	}
}
