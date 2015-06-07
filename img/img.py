#!/usr/bin/python
from PIL import Image
from PIL import ImageFilter,ImageEnhance
def inDouble(img):  
	w,h = img.size  
	return img.resize((2*w, 2*h))  
  
def filterDemo(img):  
    
	print img.format,img.size,img.mode  
	img = inDouble(img)  
	imgfilted = img.filter(ImageFilter.MedianFilter())  
	#imgfilted.show()  
	imgfilted.save("037duang.jpg")  
	jiequ(img)
def jiequ(img):
	box=(10,3,117,37)
	region=img.crop(box)
	region.save("037jiequ.jpg")
	region.show()
if __name__ == "__main__":  
	img = Image.open("037.jpg")
	filterDemo(img)  