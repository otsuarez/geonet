def main():
	main.a = ""
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
					main.a += str(hex(t)[2:])
					hashFromLatLong(lat, lon, i+latInc, j+lonInc, i, j, latInc / 4, lonInc / 4)
				q+=1
			p+=1
			
	hashFromLatLong(33.3245234+90, 75.342432432+180, 180.0, 360.0, 0, 0, 180.0/4, 360.0/4)
	print main.a[:9] #9 -> 150m
					 #8 -> 600m
					 #7 -> 2400m
					 #6 -> 9000m
	
main()