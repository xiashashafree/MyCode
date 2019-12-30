
import os
def writewords(filename):

    fp=open(filename+'.txt', 'a')
    print("请输入内容")
    while(True):
        s=input()
        if(s is '0'):
            print("输入结束")
            break;
        fp.write(s)
    fp.close()
def count(word):
    path = r'D:/untitled'
    listfile = []
    for filename in os.listdir(path):

        if ('.txt' in filename):
            listfile.append(filename)
    count=0

    for file in listfile:
        fp=open(file, 'r')
        for i in fp.readlines():
            words=i.strip().split()
            for w in words:
                if(w==word):
                    count=count+1

        fp.close()
    print(word+"在本目录所有文件中出现的次数:"+str(count))
    return count
def li():
    path=r'D:/untitled'
    listfile=[]
    for filename in os.listdir(path):

        if('.txt' in filename):
            listfile.append(filename)
def location(word):
    result=[]
    result.append("出现文件名   行数    列数 ")
    print(word+"在本目录下文件中出现的位置：")
    path = r'D:/untitled'
    listfile = []
    for filename in os.listdir(path):

        if ('.txt' in filename):
            listfile.append(filename)

    for i in range(len(listfile)):
        fp = open(listfile[i], 'r')
        line=0
        for j in fp.readlines():
            words = j.strip().split()
            count=0
            for w in words:
                if (w == word):
                   s=listfile[i]+"       "+str(line+1)+"        "+str(count+1)
                   result.append(s)
                count=count+1
        line=line+1
        fp.close()
    return result

################################################################################################################################################################################



import tkinter
import tkinter.messagebox
from tkinter import messagebox as msg
from tkinter import *

#########菜单响应消息
def build():
    print("uuu")

def exitthis():
    exit(0)
def reset(e):
    e.delete(0,END)

def framecount11():
    global entrycount1,labelword,entryword,buttoncount1,son
    son = tkinter.Tk()
    son.title("单词计数")
    son.geometry('380x300')
    labelword=tkinter.Label(son,text="请输入要计数的单词:")
    labelword.place(x=60,y=50,width=110,height=20)
    entryword=tkinter.Entry(son)
    entryword.place(x=175, y=50, width=70, height=20)
    # entrycount1 = tkinter.Entry(son)
    # entrycount1.place(x=80, y=80, width=70, height=20)
    buttoncount1 = tkinter.Button(son, text='计数', command=lambda :count1())
    buttoncount1.place(x=130, y=120, width=50, height=20)

    print('单词计数功能')

def framelocation():
    global son1,labelword1,entryword1,listbox,buttonloca2
    son1 = tkinter.Tk()
    son1.title("单词定位")
    son1.geometry('380x300')
    labelword1 = tkinter.Label(son1, text="请输入要计数的单词:")
    labelword1.place(x=90, y=50, width=110, height=20)
    entryword1 = tkinter.Entry(son1)
    entryword1.place(x=205, y=50, width=70, height=20)
    listbox=tkinter.Listbox(son1,width=200)
    listbox.place(x=80,y=80,width=200,height=80)
    buttonloca2 = tkinter.Button(son1, text='定位', command=lambda:locationwords())
    buttonloca2.place(x=130, y=170, width=50, height=20)




def createfile():
    global son2, label1, entry1,entry2, button1,button2
    son2 = tkinter.Tk()
    son2.title("创建文件")
    son2.geometry('380x300')
    label1 = tkinter.Label(son2, text="请输入文件名:")
    label1.place(x=90, y=50, width=110, height=20)
    entry1 = tkinter.Entry(son2)
    entry1.place(x=205, y=50, width=70, height=20)
    button1 = tkinter.Button(son2, text='确定', command=lambda: create())
    button1.place(x=160, y=100, width=50, height=20)
    entry2 = tkinter.Entry(son2)
    entry2.place(x=85, y=130, width=200, height=80)
    button2 = tkinter.Button(son2, text='提交', command=lambda: writefile())
    button2.place(x=160, y=220, width=50, height=20)

###计数按钮的消息响应函数
def count1():
    print("iiiiii")
    word=entryword.get()
    if(word==''):
        msg.showinfo(title='单词计数', message='输入内容为空')
    else:
        cou=count(word)
        msg.showinfo(title='单词计数', message='次数为' + str(cou))
####定位按钮的消息响应函数
def locationwords():
    word = entryword1.get()
    result=location(word)
    for i in range(len(result)):
        listbox.insert("end", result[i])

##创建文件的消息响应函数
def create():
    file= entry1.get()
    fp=open(file+".txt","w+")
    fp.close()
    msg.showinfo(title='创建文件', message='文件创建成功')

def writefile():
    file=entry1.get()
    fp = open(file + '.txt', 'a')
    s=entry2.get()
    fp.write(' '+s)
    fp.close()
    msg.showinfo(title='提交文件', message='提交成功')


########主函数
root=tkinter.Tk()
root.title("单词检索系统")
root.geometry('380x300')
##创建文件
buttonbuild=tkinter.Button(root,text='创建文件',command=createfile)
buttonbuild.place(x=90,y=100,width=50,height=20)

##单词计数
buttoncount=tkinter.Button(root,text='单词计数',command=framecount11)
buttoncount.place(x=210,y=100,width=50,height=20)

##单词定位
buttonlocation=tkinter.Button(root,text='单词定位',command=framelocation)
buttonlocation.place(x=90,y=150,width=50,height=20)


##退出程序
buttonexit=tkinter.Button(root,text='退出程序',command=exitthis)
buttonexit.place(x=210,y=150,width=50,height=20)


root.mainloop()


























