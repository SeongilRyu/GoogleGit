import urllib
url = 'http://pbmining.com'

u = urllib.urlopen(url) 
data = u.read() # u is a file-like object 
print(data)

