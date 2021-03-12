package FilleZilla.FilleZilla;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 * Hello world!
 *
 */
public class App 
{
	static final int PORT = 14147;
	  static final String HOST = "localhost";
	  static final String USER = "admin";
	  static final String PASSWORD = "admin";

	  public static void main(String[] args) throws IOException {
	    FTPClient ftpClient = new FTPClient();
	    int opcion=0;
	    String Ndirectorio;
		Scanner reader = new Scanner(System.in);

	    ftpClient.connect(HOST);

	    if(ftpClient.getReplyCode() == 220){
	   //   System.out.println(ftpClient.getReplyString());
	      System.out.println("El servidor FTP está preparado");
	    }

	    boolean isLogged = ftpClient.login(USER, PASSWORD);

	    if(isLogged){
	      System.out.println("Login correcto...");
	    } else{
	      System.out.println("Login incorrecto...");
	    }

	 
	   

	    System.out.println("1-Listar ficheros y directorios"+"\n"+"2-Desconectar"+"\n"+"3-Subir ficheros"+"\n"+"4-Descargar fichero del servidor"+ 		
	    "\n"+"5-Eliminar fichero"+"\n"+"6-Eliminar directorio"+"\n"+"7-Crear directorio"+"\n"+"8-Cambiar el directorio actual");
	    
	    
	    opcion= reader.nextInt();
	    while (opcion!=2) {
	    	
			switch (opcion) {
			case 1:
				
				   System.out.println("Directorio actual: " + ftpClient.printWorkingDirectory());

				    FTPFile[] files = ftpClient.listFiles();
				    System.out.println("Ficheros en el directorio actual: " + files.length);
				    for(int i=0;i<files.length;i++) {
				    	
					    System.out.println(files[i]);

				    	
				    }
				
				break;
				
				
				
				
				
			case 2:
				
				 
				ftpClient.disconnect();
				    
				
				break;
				
			
				
			case 3:
				
			
				InputStream inputstream ;


				String archiv2 = "/ronaldo.txt";
				 inputstream=new FileInputStream("C://Users//"+System.getProperty("user.name")+ "//Desktop/" +archiv2);

				
				ftpClient.storeFile(archiv2, inputstream);
				
				
				
				break;
			case 4:

				OutputStream outputStream1 ;


				String archivo = "/pepe.doc";
				outputStream1 = new FileOutputStream("C://Users//"+System.getProperty("user.name")+ "//Desktop/" +archivo);

				ftpClient.retrieveFile(archivo, outputStream1);
				
			
				    
				
				break;
			case 5:
							
				System.out.println("Dime el nombre del fichero que quieres borrar");
				Ndirectorio= reader.nextLine();
				Ndirectorio= reader.nextLine();
				ftpClient.dele(Ndirectorio);	
						
							    
							
				break;
			case 6:
				
				System.out.println("Dime el nombre del directorio que quieres crear");
				Ndirectorio= reader.nextLine();
				Ndirectorio= reader.nextLine();
				ftpClient.removeDirectory(Ndirectorio);
				
			    
				
				break;
			case 7:
				System.out.println("Dime el nombre del directorio que quieres crear");
				Ndirectorio= reader.nextLine();
				Ndirectorio= reader.nextLine();
				ftpClient.makeDirectory(Ndirectorio);
				
			    
				
				break;
			case 8:
				
				
				System.out.println("Dime el nombre del directorio al que quieres ir");
				Ndirectorio= reader.nextLine();
				Ndirectorio= reader.nextLine();

				if(Ndirectorio.equals("..")) {
					ftpClient.changeToParentDirectory();

				}else {
				ftpClient.changeWorkingDirectory(Ndirectorio);
				
				}
				
				   System.out.println("Directorio actual: " + ftpClient.printWorkingDirectory());

			    
				
				break;
				
				
			default:
				System.out.println("Opción no válida\n");
				break;
	
				
			}
			

			 System.out.println("1-Listar ficheros y directorios"+"\n"+"2-Desconectar"+"\n"+"3-Subir ficheros"+"\n"+"4-Descargar fichero del servidor"+ 		
					    "\n"+"5-Eliminar fichero"+"\n"+"6-Eliminar directorio"+"\n"+"7-Crear directorio"+"\n"+"8-Cambiar el directorio actual");
		    opcion= reader.nextInt();
			
	  }
}
}
