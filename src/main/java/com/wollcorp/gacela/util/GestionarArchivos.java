package com.wollcorp.gacela.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GestionarArchivos {

	private static String tempPath = "C:\\opt\\gacelaConfig\\filesTemp\\";

	public XSSFWorkbook fileToWorkbook(File file) {

		try {

			InputStream excel = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(excel);

			return wb;

		} catch (FileNotFoundException e) {

			log.error("Error on reading file: File not found");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error on reading file: File not found", e);

		} catch (IOException e) {

			log.error("Error on reading file: Invalid File");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error on reading file: Invalid File", e);

		}

	}

	/**
	 * Convierte un multipartFile a File.
	 * 
	 * @param multipartFile Objeto multipartFile a convertir.
	 * @return Objeto tipo File.
	 * @throws IOException
	 */
	public File multipartFileToFile(MultipartFile multipartFile, String filename) {

		File file = new File(tempPath + filename);

		try {

			FileOutputStream fos = new FileOutputStream(file);
			fos.write(multipartFile.getBytes());
			fos.close();

		} catch (IOException e) {
			log.error("Error on process file");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error on process file", e);
		}

		return file;
	}

	/**
	 * Guarda en el disco una lista de objetos.
	 * 
	 * @param objeto   Es la lista de objetos a guardar en disco
	 * @param filename Es el nombre del archivo que sera usado para guardar y leer.
	 */
	public void guardarObjeto(Object objeto, String filename) {

		// filename = "C:\\opt\\gacelaConfig\\filesTemp\\" + filename;
		filename = tempPath + filename;
		ObjectOutputStream oos;
		try {

			oos = new ObjectOutputStream(new FileOutputStream(filename));
			oos.writeObject(objeto);
			oos.close();

		} catch (FileNotFoundException e) {
			log.error("Error on process objects");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error on process objects", e);
		} catch (IOException e) {
			log.error("Error on process objects");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error on process objects", e);
		}
	}

	/**
	 * Lee del disco una lista guardada anteriormente de manera temporal.
	 * 
	 * @param filename Es el nombre del archivo guardado en disco.
	 * @return Lista de objetos obtenida del disco.
	 */
	public Object leerObjeto(String filename) {
		filename = tempPath + filename;
		Object objeto = null;
		ObjectInputStream ois;
		try {

			ois = new ObjectInputStream(new FileInputStream(filename));

			try {

				objeto = (Object) ois.readObject();

			} catch (ClassNotFoundException e) {
				ois.close();
				log.error("Error on reading objects");
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error on reading objects", e);
			}

			ois.close();

			return objeto;

		} catch (IOException e) {
			log.error("Error on reading objects");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error on reading objects", e);
		}
	}

	/**
	 * Elimina un archivo de la ruta de archivos temporales.
	 * 
	 * @param filename Nombre del archivo a eliminar;
	 */
	public void eliminarArchivo(String filename) {
		filename = tempPath + filename;

		File file = new File(filename);

		if (file.delete()) {
			log.info("File deleted successfully");
		} else {
			log.error("Error deleting temporal file");
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting temporal file");
		}
	}
}
