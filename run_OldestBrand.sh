hadoop fs -rm -r output

echo ""
echo "#############################"
echo "## Output wurde geloescht! ##"
echo "#############################"
echo ""

hadoop jar SportBrands-Java/oldestBrand.jar OldestBrand /user/student_63/input1 /user/student_63/output

echo ""
echo "#############################"
echo "### WordCount lief durch ####"
echo "#############################"
echo ""


hdfs dfs -ls /user/student_63/output

echo ""
echo "#######################################"
echo "### Zeige Inhalt vom Output Ordner ####"
echo "########################################"
echo ""

hdfs dfs -cat /user/student_63/output/part-r-00000

echo ""
echo "#######################"
echo "### Zeige Ergebnis ####"
echo "#######################"
echo ""