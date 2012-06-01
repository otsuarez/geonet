geonet
======

red social geolimitada


Instalacion de mongodb
----------------------

```sh
sudo mkdir -m 777 -p /data/db
cd /data/db
wget http://fastdl.mongodb.org/linux/mongodb-linux-i686-static-2.0.5.tgz
tar -zxvf mongodb-linux-i686-static-2.0.5.tgz
cd mongodb-osx-x86_64-1.6.5/bin
./mongod --rest
```

abrimos otra consola en el mismo directorio si queremos utilizar el cliente

```sh
./mongo

show datadatases
show collections
<collection>.find()
```

instalando herramientas para trabajar con python

```
sudo apt-get install python-pip python-dev build-essential 
sudo pip install --upgrade pip 
sudo pip install --upgrade virtualenv 
```

levantando el backend

```
cd /var/www/html/hackaday/api
virtualenv hackaday
. hackaday/bin/activate
pip install flup
pip install -U bottle 
python geonet.py
```
