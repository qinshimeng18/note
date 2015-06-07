# # -*- coding: utf-8 -*- 
# s1='|abc|abcde|fghabcdhishuabcuidhu'
# s=s1.split('|')
# num = 0
# s=s[1:]
# print s
# for i in s:
# 	print s[num]+'~~~~~'+i+'~~~~'+str(num)
# 	num=num+1
h="0a0b0c0d0e0f0g0h0i"
print h
s='111'
s=h
j=''
n=len(s)
print n
for i in range(len(s)/2):
	j=j+s[n-2*i-2]+s[n-2*i-1]
	
print j
# print s[2]
# print s[0:2]
# t="1d010000"
# print int(t,16)
# print t[0:2]
# num = 1
# big=0
# for i in range(len(t)/2):
# 	l=i*2
# 	a=t[l:l+2]#print int(i,16)
# 	big+=int(a,16)*16**l

# print big
# f=open('/home/lgn/Desktop/99.txt','w')
# for i in range(10):
# 	f.write('\tasdas'+"!!!\nd")
# f.close()
# # class abc():
# # 	num=0

# bb=abc()
# import struct
# f = open("/home/lgn/Desktop/blk00001.dat","rb")
# head=f.read(50000)
# def out(s):
# 	print 'not ascll:',s
# 	print 'hex:',s.encode('hex')
# w=open('/home/lgn/Desktop/eee.dat','w')
# b=head.encode('hex')
# w.write(b)
# f.close()
# w.close()
# out(head)
# h1=head[0:4]
# print struct.unpack('i',h1)
# str1=f.read(4)
# print 'str1:',str1.encode('hex')
# str1=struct.unpack('i',str1)
# print str1
# f.write(struct.pack("i",'fgdf'))
# # f = open("out.dat","rb")
# # s = struct.unpack("i",f.read(4))
# f.close()

# print s
# print type(s[0])

# print struct.unpack("i","\x66\x67\x64\x66")
# print "fgdf".encode("hex")
# a='bc'
# print struct.pack("s",a)
# f=open("out.dat","wb+")
# b=struct.pack('s',a)
# print type(b)
# b=64
# c=struct.pack('i',b)
# print c
# (a,)=struct.unpack('i',c)
# print a

# x,y=1,2
# z=['a','b','c']
# print z[1:3]
# print type(z[2])
# f.write(b)
# print 'pack',b
# print struct.unpack('i',f.read(4))
# c=struct.unpack('s',b)
# print "unpack",c
# print type(c)
# f.close()