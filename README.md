# Pasos para hacer un pequeño App que reconozca Caras (Faces) y Ojos (Eyes)

Pasos para que puedas realizar tu propio face and Eye Recognition (reconocimiento de rostro y ojos)

## Requerimientos:

- Leer la siguiente configuración para usar el OpenCV en Andorid Studio:
  https://github.com/yucaret/OpenCV-AndroidStudio
  
## Pasos:

1) Modificar el MainActivity.java, como se ve en el adjunto de este repositorio.

2) Modificar el activity_main.xml del app, como se ve en el adjunto de este repositorio.

3) Modificar el manifiesta de la apliación (ojo, de la aplicaión), tal como se ve en el archivo activity_main.xml de este repositorio.

4) Crear la clase "ObjectDetection.java", que es la clase que se encargará de realizar la detección de rostro; con este objeto creado se resolvera el pequeño error que tenian cuando modificaron el MainActivity del paso 1.

5) Identificar los siguientes archivos que se van a colocar en el sistema de archivos de tu celular:
   
   - haarcascade_frontalface_alt.xml
   - haarcascade_eye_tree_eyeglasses.xml
   
   Estos archivos se encuentra en la siguiente ruta dentro del OpenCV, en mi caso es "C:\opencv\opencv-android\opencv-342-android-sdk\sdk\etc\haarcascades", y como veran en la siguiente imagen:
   
   ![image](https://user-images.githubusercontent.com/31372472/49700410-247e3e00-fbac-11e8-9c47-253cf907a303.png)
   
6) Crear la una carpeta en su celular donde se van a colocar los archivos identificados, al ser mi celular un Android 8.0, he creado la carpeta "data" y dentro de ella he colocado los archivos identificados, ver imagen:

  ![image](https://user-images.githubusercontent.com/31372472/49700532-dff3a200-fbad-11e8-9670-4fa813e769e5.png)
  
   Para buscar esos dos archivos dentro de la aplicación van a tener que acceder por la siguiente ruta, la cual es la estructura de ruta del sistema de archivo de Android:
  
   /storage/emulated/0/data

7) Luego compilan e instalan en su celular (esto lo hace el mismo Android Studio al darle en el icono de cabeza de flecha verde)

8) Deben de darle los permisos en el celular a la App creada, como de Camara y Almacenamiento, deben de ingresar a permisos de aplicación y hacer como lo que se ve en la imagen:

   ![image](https://user-images.githubusercontent.com/31372472/49700681-0ca8b900-fbb0-11e8-8e45-1ae6a287f058.png)
   
9) Ahora si funciona tu App de reconocimiento facial y de ojos:

   Se que la imagen esta en azul, es algo que debo de investigar, pero funciona el reconocimiento :) !!!
   
   ![image](https://user-images.githubusercontent.com/31372472/49700781-4a5a1180-fbb1-11e8-9f3f-48e2b73e19b8.png)
