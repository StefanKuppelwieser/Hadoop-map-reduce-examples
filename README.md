# Hadoop map reduce examples

Some examples to show the approach of map reduce from Hadoop.

## Table SportBrands

Fictitious data, which are not true, have been used as exemplary data.

1. Column: Shows the brand
2. Column: Land from the headquarters
3. Column: Shows the sales numbers of the products so far
4. Column: Establishment of the brand

## Prerequisite

You have to ..
1. .. change the chmod of the shell files
2. .. copy the data-schema to hadoop dfs 
3. .. and create environments variables

```
chmod 757 run_AmountOfSoldProducts.sh
chmod 757 run_AverageSoldProductsPerYear.sh
chmod 757 run_NewestBrand.sh
chmod 757 run_OldestBrand.sh
chmod 757 run_SportBrands.sh

hadoop fs -rm -r input1

hadoop fs -mkdir /user/student_63
hadoop fs -mkdir input1

hadoop fs -copyFromLocal /home/student_63/file01 \input1/file01
hadoop fs -copyFromLocal /home/student_63/file02 \input1/file02
hadoop fs -copyFromLocal /home/student_63/sportBrands \input1/sportBrands

hadoop dfs -ls /user/student_63/input1/

export JAVA_HOME=/usr/java/default
export PATH=$JAVA_HOME/bin:$PATH
export HADOOP_CLASSPATH=$JAVA_HOME/lib/tools.jar
```

## Example: SportBrands

As a result you can see the brand and the founding year

```
cd ~

cd SportBrands-Java

rm -f SportBrands$IntSumReducer.class
rm -f SportBrands$TokenizerMapper.class
rm -f SportBrands.class
rm -f sportBrands.jar

/usr/bin/hadoop com.sun.tools.javac.Main SportBrands.java
jar cf sportBrands.jar SportBrands*.class

cd ..

./run_SportBrands.sh
```


## Example: AmountOfSoldProducts 

As a result you can see the amount of sold products and the brand 

```
cd ~

cd SportBrands-Java

rm -f AmountOfSoldProducts$IntSumReducer.class
rm -f AmountOfSoldProducts$TokenizerMapper.class
rm -f AmountOfSoldProducts.class
rm -f AmountOfSoldProducts.jar

/usr/bin/hadoop com.sun.tools.javac.Main AmountOfSoldProducts.java
jar cf amountOfSoldProducts.jar AmountOfSoldProducts*.class

cd ..

./run_AmountOfSoldProducts.sh
```


## Example: NewestBrand 

The brand, which has been on the market since the shortest time, is shown

```
cd ~

cd SportBrands-Java

rm -f NewestBrand$IntSumReducer.class
rm -f NewestBrand$TokenizerMapper.class
rm -f NewestBrand.class
rm -f NewestBrand.jar

/usr/bin/hadoop com.sun.tools.javac.Main NewestBrand.java
jar cf newestBrand.jar NewestBrand*.class

cd ..

./run_NewestBrand.sh
```


## Example: OldestBrand 

The brand, which has been on the market since the longest time, is shown

```

cd ~

cd SportBrands-Java

rm -f OldestBrand$IntSumReducer.class
rm -f OldestBrand$TokenizerMapper.class
rm -f OldestBrand.class
rm -f OldestBrand.jar

/usr/bin/hadoop com.sun.tools.javac.Main OldestBrand.java
jar cf oldestBrand.jar OldestBrand*.class

cd ..

./run_NewestBrand.sh
```

## Example: AverageSoldProductsPerYear

It shows the annual average of sold products since the brand is on the market 

```
cd ~

cd SportBrands-Java

rm -f AverageSoldProductsPerYear$IntSumReducer.class
rm -f AverageSoldProductsPerYear$TokenizerMapper.class
rm -f AverageSoldProductsPerYear.class
rm -f AverageSoldProductsPerYear.jar

/usr/bin/hadoop com.sun.tools.javac.Main AverageSoldProductsPerYear.java
jar cf averageSoldProductsPerYear.jar AverageSoldProductsPerYear*.class

cd ..

./run_AverageSoldProductsPerYear.sh
```
