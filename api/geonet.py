import datetime
import json
import bottle
from bottle import route, run, request, abort, get, Bottle
from pymongo import Connection
import urllib
# app = Bottle()


def geohash(entity):
#   lat = (entity['lat'])
#   lon = (entity['lon'])
  # logger.error('An error occurred'+lat)

  geohash.a = ""
  def drange(start, stop, step):
       r = start
       while r < stop:
               yield r
               r += step
  
  def hashFromLatLong(lat, lon, latRange, lonRange, latInit, lonInit, latInc, lonInc):
    p = 0
    for i in drange(latInit, latRange, latInc):
      q = 0
      for j in drange(lonInit, lonRange, lonInc):
        if (lon > j and lon < j + lonInc and lat > i and lat < i + latInc):
          t = p*4+q
          geohash.a += str(hex(t)[2:])
          hashFromLatLong(lat, lon, i+latInc, j+lonInc, i, j, latInc / 4, lonInc / 4)
        q+=1
      p+=1
      
  hashFromLatLong(lat+90, lon+180, 180.0, 360.0, 0, 0, 180.0/4, 360.0/4)
  return geohash.a[:9]


_keys = [
 "$", "&", "+", ",", "/", ":", ";", "=", "?", "@", " ", '"',
 "<", ">", "#", "%", "{", "}", "|", "\\", "^", "~", "[", "]", "`"]

_vals = [
 '%24', '%26', '%2B', '%2C', '%2F', '%3A', '%3B', '%3D', '%3F',
 '%40', '%20', '%22', '%3C', '%3E', '%23', '%25', '%7B', '%7D',
 '%7C', '%5C', '%5E', '%7E', '%5B', '%5D', '%60']

def encode(str=""):
 """ URL Encodes a string with out side effects
 """
 return "".join([_swap(x) for x in str])

def decode(str=""):
 """ Takes a URL encoded string and decodes it with out side effects
 """
 if not str: return None
 for v in _vals:
   if v in str: str = str.replace(v, _keys[_vals.index(v)])
 return str

def _swap(x):
 """ Helper function for encode.
 """
 if x in _keys: return _vals[_keys.index(x)]
 return x
# @app.route('/updates', method=['POST', 'GET','PUT'])
# @app.route('/updates', method=['GET','POST'])
# def hello():
#     return "Hello World!"

connection = Connection('localhost', 27017)
db = connection.mydatabase
geopost = db.post

@route('/login', method=['POST','PUT','GET'])
def login():
  return "OK"

# @app.post('/updates')
# @route('/updates', method=['POST','PUT','GET'])
# @route('/updates', method=['POST','PUT'])
# @app.route('/updates', method=['POST'])
def updates():
  # data = request.body.readline()
  # data = { "lat" : request.forms.lat, "text" : request.forms.texto, "lon" : request.forms.lon}

  # if not data:
  #   abort(400, 'No data received')
  # # entity = json.loads(data)
  # # entity = data
  # # msg = geohash(entity)
  # try:
  #   db['updates'].save(data)
  # except ValidationError as ve:
  #   abort(400, str(ve))
  return post_list()
  # return "Hello World!"+entity['lat']




@route('/updates', method=['POST','PUT','GET'])
def post_list():
  d = datetime.datetime.now() - datetime.timedelta(seconds=5)
  # listado ={}
  connection = Connection('localhost', 27017)
  db = connection.mydatabase
  geopost = db.post
  listado = geopost.find({'date': {'$gt': d}}).sort("date").count()
  # for post in geopost.find({'date': {'$gt': d}}).sort("date"):
  #   listado += json.dumps(post)
  # records = dict((record['_id'], record) for record in listado)
  # return (str(list(geopost.find({'date': {'$gt': d}}).sort("date"))))
  return (str(list(geopost.find())))





@route('/post', method='POST')
# @app.route('/post')
def put_post():
  data = request.body.readline()
  dada = urllib.unquote(data)
  lat = request.forms.lat
  lon = request.forms.lon
  texto = request.forms.text
  # data = json.dumps({"lat":lat,"lon":lon,"text":text})
  # data = json.dumps(
  # data = {"lat":"asdfasdf","lon":"longitud","text":"texto texto"}
  d = datetime.datetime.now()
  # data = {"lat":lat,"lon":lon,"text": texto,"date": datetime.datetime.utcnow()}
  data = {"lat":lat,"lon":lon,"text": texto,"date": d}
  # data = {"lat":lat,"lon":lon,"text":request.body.readline()}

  # data = request.json()
  # print data
  # app.logger.debug('A warning occurred (%s )', data)
  if not data:
    abort(400, 'No data received')
  # entity = json.loads(data)
  entity = decode(data)
  # lat = request.args.get('lat')
  if not entity.has_key('text'):
    abort(400, 'No text message specified')
  try:
    db['post'].save(data)
  except ValidationError as ve:
    abort(400, str(ve))
  # return lat
  return "OK"


@route('/documents', method='PUT')
def put_document():
  data = request.body.readline()
  if not data:
    abort(400, 'No data received')
  entity = json.loads(data)
  if not entity.has_key('_id'):
    abort(400, 'No _id specified')
  try:
    db['documents'].save(entity)
  except ValidationError as ve:
    abort(400, str(ve))
  
@route('/documents/:id', method='GET')
def get_document(id):
  entity = db['documents'].find_one({'_id':id})
  if not entity:
    abort(404, 'No document with id %s' % id)
  return entity

run(host='localhost', port=5000)
