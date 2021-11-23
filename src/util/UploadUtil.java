package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import config.Const;

public class UploadUtil {
	public static List<String> uploadDefault(HttpServletRequest request, String[] extensions)
			throws IOException, ServletException {
		return upload(Const.UPLOAD_PATH, request, extensions);
	}

	public static List<String> upload(String uploadPath, HttpServletRequest request, String[] extensions)
			throws IOException, ServletException {
		List<String> listExtensions = (extensions == null) ? null : Arrays.asList(extensions);
		List<String> listFilePathUploaded = new ArrayList<String>();

		uploadPath = (uploadPath.endsWith("/")) ? uploadPath : uploadPath + "/";

		File uploadFolder = new File(uploadPath);
		if (!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}

		String fileName, extension, fullUploadPath;
		int i = 0;
		for (Part filePart : request.getParts()) {
			fileName = renameFile(filePart.getSubmittedFileName(), "upload_", String.valueOf(i++));
			extension = getExtension(fileName);

			if (listExtensions != null && !listExtensions.contains(extension)) {
				continue;
			}

			fullUploadPath = uploadPath + fileName;
			filePart.write(fullUploadPath);

			listFilePathUploaded.add(fullUploadPath);
		}

		return listFilePathUploaded;
	}

	// lấy đuôi file
	public static String getExtension(Part filePart) {
		if (filePart == null) {
			return null;
		}

		String fileName = filePart.getSubmittedFileName();

		return getExtension(fileName);
	}

	public static String getExtension(String fileName) {
		if (fileName == null) {
			return null;
		}

		String[] arrayString = fileName.split("\\.");
		String extension = arrayString[arrayString.length - 1];

		return extension;
	}

	// tạo tên mới
	public static String renameFile(String oldFileName, String prefix, String suffixes) {
		String extension = getExtension(oldFileName);

		prefix = (prefix == null) ? "" : prefix;
		suffixes = (suffixes == null) ? "" : suffixes;

		String newFileName = prefix + System.currentTimeMillis() + suffixes + "." + extension;

		return newFileName;
	}

	public static void main(String[] args) {
		System.out.println(renameFile("hello.jpg", "Upload_", "1"));
	}
}
