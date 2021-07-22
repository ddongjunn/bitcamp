package bit.com.a;

import javax.servlet.ServletContext;

import org.springframework.http.MediaType;

public class MediaTypeUtils {
	
	public static MediaType getMediaTypeForFileName(ServletContext servletContext, String fileName) {
		
		String minType = servletContext.getMimeType(fileName);
		try {
			MediaType mediaType = MediaType.parseMediaType(minType);
			return mediaType;
		}catch(Exception e) {
			return MediaType.APPLICATION_OCTET_STREAM;
		}
	}
}
