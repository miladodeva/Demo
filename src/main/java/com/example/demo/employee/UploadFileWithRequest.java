package com.example.demo.employee;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
public class UploadFileWithRequest {

    public static void uploadFile(String urlString, String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found: " + filePath);
                return;
            }

            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set connection properties
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            String boundary = "*****";
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            // Create the payload for the file
            FileInputStream fileInputStream = new FileInputStream(file);
            OutputStream outputStream = connection.getOutputStream();

            // Write file contents to the output stream
            outputStream.write(("--" + boundary + "\r\n").getBytes());
            outputStream.write(("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"\r\n").getBytes());
            outputStream.write(("Content-Type: application/octet-stream\r\n\r\n").getBytes());

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.write(("\r\n--" + boundary + "--\r\n").getBytes());
            outputStream.close();
            fileInputStream.close();

            // Get response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("File uploaded successfully.");
            } else {
                System.out.println("Failed to upload file. Response code: " + responseCode);
                // Print server response message for more details
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println("Server response: " + response.toString());
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) {
//        String urlString = "http://example.com/upload";
//        //String filePath = "/path/to/your/file.txt";
//        String filePath = "C:/Users/mila.dodeva/Desktop/test.vsdx";
//        uploadFile(urlString, filePath);
//    }
}
