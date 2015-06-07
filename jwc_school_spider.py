#coding=utf-8
import urllib
import urllib2
import re
import threading
import time

numstart=213130000
numend=213131150
url ="http://xk.urp.seu.edu.cn/jw_service/service/stuCurriculum.action"
name=re.compile('姓名:([^<]+)')
xuehao=re.compile('学号:(\d+)')
yikatong=re.compile('一卡通号:(\d+)')
yuanxi=re.compile('院系:\[\d+\]([^<]+)')
zhuanye=re.compile('专业:\[\d+\]([^<]+)')
stuCurriculum=open('stuCurriculum.txt','a')


def outln(the_page,s):
	st=s.findall(the_page)
	if st:
		st = st[0]
		stuCurriculum.write(st)
		stuCurriculum.write('\t')
		print st

def spider(numstart,numend):

	for number in range(numstart,numend):
		values = {'queryStudentId':number,
				'queryAcademicYear':'14-15-2'}
		data = urllib.urlencode(values)
		req = urllib2.Request(url, data)
		try:
			response=urllib2.urlopen(req)
		except:
			print 'meiyou!'
		else:
			the_page = response.read()
			outln(the_page,name)
			outln(the_page,xuehao)
			outln(the_page,yikatong)
			outln(the_page,yuanxi)
			outln(the_page,zhuanye)






class myThread (threading.Thread):
	def __init__(self, threadID, name, nums,nume):
		threading.Thread.__init__(self)
		self.threadID = threadID
		self.name = name
		self.nums = nums
		self.nume=nume
	def run(self): 
		print "Starting " + self.name+"\n"
		print_time(self.name)
		spider(self.nums ,self.nume)
		print "Exiting " + self.name+"\n"


def print_time(threadName):
	print "%s: %s\n" % (threadName, time.ctime(time.time()))



thread1 = myThread(1, "Thread-1", 213131140,213131145)
thread2 = myThread(2, "Thread-2", 213131145,213131150)
thread1.start()
thread2.start()
print "Exiting Main Thread"


