hadoop fs -rm -r output

echo ""
echo "########################"
echo "## Output was deleted ##"
echo "########################"
echo ""

hadoop jar SportBrands-Java/averageSoldProductsPerYear.jar AverageSoldProductsPerYear /user/student_63/input1 /user/student_63/output

echo ""
echo "######################"
echo "### Java run done ####"
echo "#######################"
echo ""


hdfs dfs -ls /user/student_63/output

echo ""
echo "################################################"
echo "### Show the content of the outpult folder ####"
echo "###############################################"
echo ""

hdfs dfs -cat /user/student_63/output/part-00000

echo ""
echo "#######################"
echo "### Show the results ####"
echo "#######################"
echo ""