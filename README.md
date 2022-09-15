### 说明文档
#### 说明  
        主要用于记录当前应用的activity，应用切换前后台的监听

#### 接入方式
##### 在项目中设置资源来源
```
maven { url = uri("https://gitee.com/liu-huiliang/jarlibs/raw/master") }
```
##### 在模块中配置应用包
```
implementation 'com.lhl.applife:applife:1.0.2'
```
#### 使用
##### 在application中初始化
```
        #一定要在application中初始化，否则会不准确
        AppLife life = new AppLife(Application);
```

##### 注册生命周期监听
```
AppLife.registerAppLifeListener(AppLifeListener);
```
###### 回调说明
```
onAppPause   app退出到后台回调
onAppResume  app回到前台回调
```

##### 获取activity
```
List<Activity> activities = AppLife.class2Activity(Class)
```
###### 参数说明  
        传入参数为你需要获取的activity对应的class