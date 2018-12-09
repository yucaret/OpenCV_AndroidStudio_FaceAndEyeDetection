package kaisha.no.vicente.ejemplo_appface_007;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.util.List;

public class ObjectDetection {

    private String sMobileRoot;
    private String sDataFolder;
    private String sFileFaceDetection;
    private String sFileEyeDetection;
    private CascadeClassifier ccFaceCascade;
    private CascadeClassifier ccEyesCascade;


    public ObjectDetection(){
        sMobileRoot = "/storage/emulated/0/";
        sDataFolder = "data/";
        sFileFaceDetection = "haarcascade_frontalface_alt.xml";
        sFileEyeDetection = "haarcascade_eye_tree_eyeglasses.xml";

        ccFaceCascade = new CascadeClassifier();
        ccEyesCascade = new CascadeClassifier();

        if (!ccFaceCascade.load(sMobileRoot + sDataFolder + sFileFaceDetection)) {
            System.err.println("Error al cargar: " + sFileFaceDetection);
        }
        if (!ccEyesCascade.load(sMobileRoot + sDataFolder + sFileEyeDetection)) {
            System.err.println("Error al cargar: " + sFileEyeDetection);
        }
    }

    public void DetectAndDisplay(Mat mRgba) {

        //En escala de grises
        Mat mGray = new Mat();
        Imgproc.cvtColor(mRgba, mGray, Imgproc.COLOR_BGR2GRAY);
        Imgproc.equalizeHist(mGray, mGray);

        //Detecta la Cara
        MatOfRect morFaces = new MatOfRect();
        ccFaceCascade.detectMultiScale(mGray, morFaces,1.2,5,0,new Size(2,2),new Size(1000,1000));

        List<Rect> lrFaces = morFaces.toList();

        for (Rect rFace : lrFaces) {
            Point pCenterFace = new Point(rFace.x + rFace.width / 2, rFace.y + rFace.height / 2);
            Size sSizeFaceDetected = new Size(rFace.width / 2, rFace.height / 2);
            Scalar sScalarColorFaceDetected = new Scalar(0, 255, 0);

            Imgproc.ellipse(mRgba, pCenterFace, sSizeFaceDetected, 0, 0, 360, sScalarColorFaceDetected);

            // se obtiene el Mat de solo la cara
            Mat mGrayFace = mGray.submat(rFace);

            //Por cada Cara, detecta los ojos
            MatOfRect morEyes = new MatOfRect();
            ccEyesCascade.detectMultiScale(mGrayFace, morEyes);

            List<Rect> lrEyes = morEyes.toList();

            for (Rect rEye : lrEyes) {
                Point pEyeCenter = new Point(rFace.x + rEye.x + rEye.width / 2, rFace.y + rEye.y + rEye.height / 2);
                int iRadio = (int) Math.round((rEye.width + rEye.height) * 0.25);
                Scalar sScalarColorEyeDetected = new Scalar(0, 102, 255);

                Imgproc.circle(mRgba, pEyeCenter, iRadio, sScalarColorEyeDetected, 4);
            }
        }
    }
}
