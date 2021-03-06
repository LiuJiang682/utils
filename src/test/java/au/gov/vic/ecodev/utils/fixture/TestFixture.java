package au.gov.vic.ecodev.utils.fixture;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TestFixture {

	public static File getZipFile(final String string) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("Test String");

		File f = new File(string);
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
		ZipEntry e = new ZipEntry("mytext.txt");
		out.putNextEntry(e);

		byte[] data = sb.toString().getBytes();
		out.write(data, 0, data.length);
		out.closeEntry();

		out.close();
		return f;
	}
	
	public static File getDirectoryZipFile(final String string) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("Test String");

		File f = new File(string);
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
		ZipEntry e = new ZipEntry("abc/mytext.txt");
		out.putNextEntry(e);

		byte[] data = sb.toString().getBytes();
		out.write(data, 0, data.length);
		out.closeEntry();

		out.close();
		return f;
	}
}
