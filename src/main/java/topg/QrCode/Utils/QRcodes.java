package topg.QrCode.Utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import topg.QrCode.model.Student;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRcodes {

    public static void codeGenerator(Student student) {
        String path = "C:\\Users\\AYOMIDE\\Pictures\\Qrcode\\";
        String QrcodeName = path + student.getName() + student.getId() + "-QRCODE.png";

        try {
            // QR Code Writer instance
            QRCodeWriter qrcodeConverter = new QRCodeWriter();

            // Encode student data into a QR code format
            BitMatrix bitMatrix = qrcodeConverter.encode(
                    "ID: " + student.getId() + "\n" +
                            "Firstname: " + student.getName() + "\n" +
                            "Email: " + student.getEmail() + "\n" +
                            "Phone Number: " + student.getMobile(),
                    BarcodeFormat.QR_CODE, 400, 400
            );

            // Define the path where the QR code will be saved
            Path outputPath = FileSystems.getDefault().getPath(QrcodeName);

            // Write the BitMatrix as a PNG file to the defined path
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", outputPath);

            System.out.println("QR Code generated successfully: " + QrcodeName);
        } catch (Exception e) {
            System.err.println("Error occurred while generating QR Code: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
