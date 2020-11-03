i=1
while [ $i -lt 520 ]
do
    cp "./Manual/Before/before_"$i".java" "./Manual/Before/before_"$((i+669))".java"
    i=$((i+1)) 
done