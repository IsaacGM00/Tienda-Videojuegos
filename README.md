Para levantar la página web, se hace desde dos perspectivas:
<ul>
   <li><b>Backend</b></li>
   <li><b>Frontend</b></li>
</ul>

<h2 align="center">------ BACKEND ------</h2>
1. Posicionarse en la carpeta "backend" (puede ser desde cualquier terminal)  
   ![image](https://github.com/user-attachments/assets/d27b2a11-1281-4a31-8fa1-2890bc4e3f9d)
2. Ejecutar el comando `mvn clean install` para compilar esta parte y debe arrojar un resultado como se muestra a continuación:  
   ![image](https://github.com/user-attachments/assets/f99f2187-09d4-4606-95ee-338703c1d36d)
3. Para levantar el servicio, se ejecuta el comando `mvn spring-boot:run`; se tiene que ver como se aprecia a continuación:  
   ![image](https://github.com/user-attachments/assets/4bea1f9b-bb3f-4322-9364-3c0c57a66066)
4. Una vez realizado lo anterior, es posible visualizar los endpoints en "Postman" y/o "Swagger".


<b>Postman</b>
1. En la parte superior de la aplicación, se coloca la siguiente url: http://localhost:8080/api/juegos. Del lado izquierdo del link, se puede modificar la acción (POST, DELETE, PUT)
   <img width="1433" height="138" alt="image" src="https://github.com/user-attachments/assets/e2550779-63db-4082-8d36-8b21cdff6d47" />
2. En caso de realizar accion POST y PUT, se selecciona la pestaña "Body" y en la esquina derecha, seleccionar "JSON"
   <img width="740" height="236" alt="image" src="https://github.com/user-attachments/assets/ed92b372-1f73-4c02-af68-57f7f390c6ad" />
3. Se coloca el cuerpo de los datos a registrar acorde a las variables existentes en el codigo
   <img width="615" height="217" alt="image" src="https://github.com/user-attachments/assets/654ec918-5fbc-408a-aa67-ad6e0809bbbe" />
4. Se le da clic en el botón "Send" y deberá aparecer un mensaje 200 de éxito
   <img width="798" height="18" alt="image" src="https://github.com/user-attachments/assets/a89a92be-f1fa-45d6-88f3-34c0e41820e7" />
5. En el caso de las acciones GET y DELETE, solo se coloca la url (sin escribir el cuerpo JSON)
   <img width="1426" height="976" alt="image" src="https://github.com/user-attachments/assets/c1e516e9-e6c1-42c8-9db6-e2bed519e429" />
   <img width="725" height="233" alt="image" src="https://github.com/user-attachments/assets/922d0551-f305-4d32-8e67-edd147df5c65" />
6. Aparte del módulo Juegos, existen otros dos: Mandos y Consolas, para la ejecución de los endpoints se realiza exactamente los mismos pasos, nada más que con las urls http://localhost:8080/api/mandos y http://localhost:8080/api/consolas respectivamente.

<b>NOTA: </b> en este caso, para consultar los registros realizados, se ingresa a H2.
<li>Se escribe en el navegador el sigiente link: http://localhost:8080/h2-ui y se tiene que ver esta pantalla. Se ajustan los parametros de "JDBC URL", "user" y "password" declarados en el archivo de properties.</li>
<img width="648" height="407" alt="image" src="https://github.com/user-attachments/assets/4b52b001-0d88-47ac-b7e5-8c292b8a7a55" />
<li>Se da clic en "Test Connection" para corroborar que los parámetros sean correctos y tiene que arrojar un mensaje exitoso.</li>
<img width="633" height="473" alt="image" src="https://github.com/user-attachments/assets/9553732b-a6cd-438b-b0e0-7b3303162036" />
<li>Después, se le da clic en "Connect" y se tiene que visualizar la sigiente pantalla.</li>
<img width="1912" height="372" alt="image" src="https://github.com/user-attachments/assets/56a5ee0b-5289-4e17-802c-e2944c201e45" />
<li>Se realiza la consulta a la tablas: "CONSOLAS", "JUEGOS" y "MANDOS", arrojando los registros.</li>
<img width="752" height="992" alt="image" src="https://github.com/user-attachments/assets/ad900f6e-c53b-4b76-a58b-228f4c84894b" />

<b>Swagger</b>
1. Se ingresa en el navegador el siguiente link: http://localhost:8080/swagger-ui/index.html
2. La pantalla se tiene que ver como en la siguiente imagen:
   <img width="1913" height="950" alt="image" src="https://github.com/user-attachments/assets/7410c7de-97bd-4273-9ec6-b239cc38016a" />
3. Para inicializar un endpoint, se le da clic en el botón "Try it out"
   <img width="1421" height="240" alt="image" src="https://github.com/user-attachments/assets/ec1d1ba2-9a4b-4bf2-98cb-0eaad06bbac8" />
4. Luego, para su ejecución, se le da clic en el botón "Execute"
   <img width="1420" height="217" alt="image" src="https://github.com/user-attachments/assets/95aa7109-1eee-4821-8831-cda02b77ba3f" />
5. Se visualizará los registros y el mensaje de 200 (ejecución exitosa)
   <img width="1427" height="876" alt="image" src="https://github.com/user-attachments/assets/087b7af7-066d-448c-b6d1-b3159409470d" />
6. En el caso de realizar PUT y POST, se coloca el cuerpo JSON con los valores a registrar y actualizar respectivamente
   <img width="1415" height="582" alt="image" src="https://github.com/user-attachments/assets/08b376c7-67cc-4bfa-8433-176e00dab8bf" />
7. Tiene que arrojar un mensaje de 200, es decir, que fue exitosa la acción
   <img width="1307" height="268" alt="image" src="https://github.com/user-attachments/assets/718c638d-0463-4440-a3f5-9c52ac69145b" />
8. Para los demás endpoints existentes, se realizan los mismos pasos anteriores, dependiendo si solicita parámetros o no.

<b style="text-align: center;">------ FRONTEND ------ </b>
1. Posicionarse en la carpeta "frontend" (de preferencia en la terminal cmd, ya que powershell no es compatible)
   <img width="395" height="42" alt="image" src="https://github.com/user-attachments/assets/026499c9-a592-4ad0-bb23-7f94f2ff6046" />
2. Ejecutar el comando "ng serve" para levantar esta parte y se tiene que ver como a continuación:
   <img width="592" height="357" alt="image" src="https://github.com/user-attachments/assets/10324e59-52ec-4c5a-a827-eba96326486c" />
3. Una vez realziado los dos pasos anteriores, se ingresa al siguiente link en el navegador: http://localhost:4200/
4. Se tiene que visualizar como se aprecia en la siguiente imagen:
   <img width="1917" height="996" alt="image" src="https://github.com/user-attachments/assets/4cd6ee48-7a24-4be6-8854-811a5174d923" />
5. Finalmente, es posible navegar en las demás pestañas, por ejemplo:
   <img width="1916" height="995" alt="image" src="https://github.com/user-attachments/assets/bb881aca-65a7-408e-aee0-7d0597b8261a" />
   <img width="1917" height="982" alt="image" src="https://github.com/user-attachments/assets/3a698ff1-a7c9-484d-860e-4d0ca9f29d8c" />

<b style="text-align: center;">------ IMPORTANTE ------ </b>
Primero se levanta la parte de backend y después la de frontend, de lo contario, no se mostrará la información de los productos almacenados en la base de datos (H2) en la página y solo se apreciará el diseño.
