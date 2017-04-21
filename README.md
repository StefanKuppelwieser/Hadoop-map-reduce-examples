# Hadoop map reduce examples

Some examples to show the approach of map reduce from Hadoop.
Fictitious data, which are not true, have been used as exemplary data.

## Prerequisite

You have to copy the data-schema to hadoop dfs and create environments variables

`hadoop fs -mkdir /user/<YOUR USER>`
`hadoop fs -mkdir input1`

`hadoop fs -copyFromLocal /home/<YOUR USER>/file01 \input1/file01`
`hadoop fs -copyFromLocal /home/<YOUR USER>/file02 \input1/file02`
`hadoop fs -copyFromLocal /home/<YOUR USER>/sportBrands \input1/sportBrands`

`hadoop dfs -ls /user/<YOUR USER>/input1/`

`export JAVA_HOME=/usr/java/default`
`export PATH=$JAVA_HOME/bin:$PATH`
`export HADOOP_CLASSPATH=$JAVA_HOME/lib/tools.jar`

## Example: SportBrands

As a result you can see the brand and the founding year


`cd SportBrands-Java`

`rm -f SportBrands$IntSumReducer.class`
`rm -f SportBrands$TokenizerMapper.class`
`rm -f SportBrands.class`
`rm -f sportBrands.jar`

`/usr/bin/hadoop com.sun.tools.javac.Main SportBrands.java`
`jar cf sportBrands.jar SportBrands*.class`

`cd ..`

`./run_SportBrands.sh`



## Example: SportBrands AmountOfSoldProducts 

As a result you can see the amount of sold products and the brand 


`cd SportBrands-Java`

`rm -f AmountOfSoldProducts$IntSumReducer.class`
`rm -f AmountOfSoldProducts$TokenizerMapper.class`
`rm -f AmountOfSoldProducts.class`
`rm -f AmountOfSoldProducts.jar`

`/usr/bin/hadoop com.sun.tools.javac.Main AmountOfSoldProducts.java`
`jar cf amountOfSoldProducts.jar AmountOfSoldProducts*.class`

`cd ..

`./run_AmountOfSoldProducts.sh`




## Example: SportBrands AmountOfSoldProducts 

The brand, which has been on the market since the shortest time, is shown

`cd SportBrands-Java`

`rm -f NewestBrand$IntSumReducer.class`
`rm -f NewestBrand$TokenizerMapper.class`
`rm -f NewestBrand.class`
`rm -f NewestBrand.jar`

`/usr/bin/hadoop com.sun.tools.javac.Main NewestBrand.java`
`jar cf newestBrand.jar NewestBrand*.class`

`cd ..`

`./run_NewestBrand.sh`



## Example: SportBrands OldestBrand 

`The brand, which has been on the market since the longest time, is shown`


`cd SportBrands-Java`

`rm -f OldestBrand$IntSumReducer.class`
`rm -f OldestBrand$TokenizerMapper.class`
`rm -f OldestBrand.class`
`rm -f OldestBrand.jar`

`/usr/bin/hadoop com.sun.tools.javac.Main OldestBrand.java`
`jar cf oldestBrand.jar OldestBrand*.class`

`cd ..`

`./run_NewestBrand.sh`






## AverageSoldProductsPerYear #####"

It shows the annual average of sold products since the brand is on the market 


`cd ~`

`cd SportBrands-Java`

`rm -f AverageSoldProductsPerYear$IntSumReducer.class`
`rm -f AverageSoldProductsPerYear$TokenizerMapper.class`
`rm -f AverageSoldProductsPerYear.class`
`rm -f AverageSoldProductsPerYear.jar`

`/usr/bin/hadoop com.sun.tools.javac.Main AverageSoldProductsPerYear.java`
`jar cf averageSoldProductsPerYear.jar AverageSoldProductsPerYear*.class`

`cd ..`

`./run_AverageSoldProductsPerYear.sh`
