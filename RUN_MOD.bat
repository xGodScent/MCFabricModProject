@echo off
cls
title runClient
echo.
java -version
echo.
echo [101;93m [!] WARNING: Please confirm that java version is equal to 1.8._ [0m
echo    - if java ver == 1.8._  :  continue.
echo    - if NOT java ver == 1.8._  :  close cmd window and download java 1.8 from the oracle website.
echo.

pause
color 0a
cls
title run client $[debug]

cd .\mod_files\
.\gradlew runClient

echo.
echo.
echo.
echo [101;93m PROGRAM FINISHED! PRESS ANY KEY TO CLOSE [0m

pause
cls
exit