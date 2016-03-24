# MoySklad
Сборка осуществлялась при помощи Maven. Для того чтобы собрать программу необходимо иметь установленный maven. Сборка:

1. В командной строке вбить путь до папки в которой лежит pom.xml;

2. Далее команда "mvn compile" для компиляции;

3. И "mvn package".

В результате мы получим файл "MoySklad.jar"

Для того чтобы запустить программу необходимо:

1. В командной строке вбить путь до папки содержащей "MoySklad.jar" ({base.dir}/target);

2. А также использовать команду "java -jar MoySklad.jar <Имя файла>"

где <имя файла> - абсолютное имя файла из которого будет производиться чтение.
