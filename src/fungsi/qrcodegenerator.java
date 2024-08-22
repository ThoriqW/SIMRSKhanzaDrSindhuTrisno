
package fungsi;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class qrcodegenerator {

    public static void generateQRCodeImage(String text, int width, int height, String filePath, String logoPath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        BufferedImage logoImage = ImageIO.read(new File(logoPath));

        // Resize the logo
        int logoWidth = qrImage.getWidth() / 5; // Logo size relative to QR code size
        int logoHeight = qrImage.getHeight() / 4;
        Image resizedLogo = logoImage.getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
        BufferedImage resizedLogoImage = new BufferedImage(logoWidth, logoHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedLogoImage.createGraphics();
        g2d.drawImage(resizedLogo, 0, 0, null);
        g2d.dispose();

        // Calculate the delta height and width for centering the logo
        int deltaHeight = qrImage.getHeight() - resizedLogoImage.getHeight();
        int deltaWidth = qrImage.getWidth() - resizedLogoImage.getWidth();

        BufferedImage combined = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) combined.getGraphics();
        g.drawImage(qrImage, 0, 0, null);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g.drawImage(resizedLogoImage, Math.round(deltaWidth / 2), Math.round(deltaHeight / 2), null);

        ImageIO.write(combined, "png", new File(filePath));
    }

//    public static void main(String[] args) {
//        try {
//            String text = "Teks yang ingin ditampilkan saat QR code discan";
//            String filePath = "D:\\test.png";
//            String logoPath = "D:\\logo_qrcode.png"; 
//
//            // Memastikan file logo ada di lokasi yang tepat
//            File logoFile = new File(logoPath);
//            if (!logoFile.exists()) {
//                throw new IOException("Logo file tidak ditemukan di path: " + logoPath);
//            }
//
//            generateQRCodeImage(text, 300, 300, filePath, logoPath);
//            System.out.println("QR code dengan logo berhasil dibuat.");
//        } catch (WriterException | IOException e) {
//            System.err.println("Tidak dapat membuat QR code: " + e.getMessage());
//        }
//    }
}
