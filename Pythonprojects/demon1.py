



#            ############定义数据集列表
# resultSet=[]         ##存储每个测试值的分类结果
# dataSet = []         ##鸢尾花训练数据集
# labels = []          ##训练集的标签
#
#             ###########从文件中读取训练数据
# filename='iris.txt'
# fr = open(filename)
# for line in fr.readlines():
#     lineArr = line.strip().split(" ")
#     dataSet.append([float(lineArr[0]),float(lineArr[1]),float(lineArr[2]),float(lineArr[3])])  ##读取特征值（4种）
#     labels.append([str(lineArr[4])])                                                           ##读取标签（2种）
#
#              ############从文件中读取测试数据
# testData=[]
# labels1=[]
# filename1='test.txt'
# fr = open(filename1)
# for line in fr.readlines():
#     lineArr = line.strip().split(" ")
#     testData.append([float(lineArr[0]),float(lineArr[1]),float(lineArr[2]),float(lineArr[3])])  ##读取特征值（4种）
#     labels1.append([str(lineArr[4])])
#
#            #############算法主体
# distance=[]        #####储存测试点与各个样本点的距离值
# print(len(distance))
# for j in range(len(testData)):                                ##嵌套for语句用来计算每个测试点与各个样本点的距离
#     for i in range(len(dataSet)):
#         distance.append((((dataSet[i][0]-testData[j][0])**2+(dataSet[i][1]-testData[j][1])**2
#                           +(dataSet[i][2]-testData[j][2])**2+(dataSet[i][3]-testData[j][3])**2)**0.5))
#                               ##计算测试点到训练集各点的距离
#     set={i:j for i,j in zip(distance,labels)}                  ###将距离和已知科学的标签值按键值对应储存
#     set=sorted(set.items(),key=lambda d:d[0],reverse =True)
#     k=15
#     label1=[]       ##存储前k个距离的标签值
#     for i in range(k):
#         label1.append(set[i][1])
#     result=max(label1, key=label1.count)                        ##result值为label中个数最大的值
#     print("当k为"+str(k)+"时：预测分类结果为："+str(result))    ###每次输出一个测试点的分类结果
#     resultSet.append(result)             ##将分类结果存储到数据集标签集合中
#
# ##################计算本次对所有测试点的分类结果的score值
# labelcount=0                             #####分类正确的标签个数
# for i in range(len(testData)):
#         if(labels1[i]==resultSet[i]):
#             labelcount=labelcount+1
# score=labelcount/len(testData)
# print("score: "+str(score ))



# print('请输入三角形的三条边')
# a=(int)(input('输入第1条边：'))
# b=(int)(input('输入第2条边：'))
# c=(int)(input('输入第3条边：'))
# while((a+b<c or a+b==c) or ( a+c<b or a+c==b)or (b+c<a or b+c==a)):
#     print('不能构成三角形，请重新输入：')
#     a = (int)(input('输入第1条边：'))
#     b = (int)(input('输入第2条边：'))
#     c = (int)(input('输入第3条边：'))
# if(a==b and b==c and a==c):
#     print('为等边三角形')
#
# elif(a!=b and b!=c and c!=a):
#     print('为一般三角形')
# else:
#     print('为等腰三角形')

# username='zhangshan'
# password='Python123'
# user=input('输入用户名：')
# password1=input('输入密码：')
# while(user!=username or password!=password1):
#     if(user!=username):
#         print('用户名错误，请重新输入',end=' ')
#         user = input()
#     if(password!=password1):
#         print('对不起,密码错误,无法登录，请重新输入信息。')
#         user = input('输入用户名：')
#         password1 = input('输入密码：')
# print('登录成功')


# print('请输入三个整数：')
# a=(int)(input('输入第1个整数：'))
# b=(int)(input('输入第2个整数：'))
# c=(int)(input('输入第3个整数：'))
# max=a
# if(max<b):
#     max=b
#     if(max<c):
#       max=c
# print('max= '+str(max))

# print('判别一元二次方程ax^2+bx+c=0的根')
# a=(float)(input('输入第1个数：'))
# b=(float)(input('输入第2个数：'))
# c=(float)(input('输入第3个数：'))
# jude=b**2-4*a*c
# if(jude<0):
#     print('方程的解为虚数')
# elif(jude>0):
#     print('方程的解为两个实数：')
#     a1 = (-b + ((jude)**0.5))/(2 * a)
#     a2 = (-b - ((jude) ** 0.5)) / (2* a)
#     print(a1)
#     print(a2)
# else:
#     print('方程的解为一个实数：')
#     a3=-b/(2*a)
#     print(a3)

i=1300000000
year=0
while(i<2600000000):
    year=year+1
    i=i*(1+0.008)
print(year)



































