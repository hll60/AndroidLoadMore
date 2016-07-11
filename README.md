# AndroidLoadMore

Android Load More Container

Android 列表组件上拉加载功能

# 功能点：

1、滑动到底部时自动加载

2、可以设置不自动加载，手动点击【加载更多】

3、可以使用默认的LoadMoreDefaultView

4、提供LoadMoreHandler和LoadMoreUIHandler接口进行扩展

##目前仅实现了ListView的上拉加载功能

# 使用：
## 步骤1  
添加jitpack仓库  

    allprojects {
		  repositories {
		  	maven { url "https://jitpack.io" }
	  	}
	  }
添加依赖  

    dependencies {
	        compile 'com.github.huangliulin:AndroidLoadMore:1.1'
	  }

## 步骤 2
在xml布局文件中添加如下代码  

    <com.hll.android.loadmore.LoadMoreListViewContainer
            android:id="@+id/loadMoreContainerLL"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">
    
            <ListView
            ../>
               
    </com.hll.android.loadmore.LoadMoreListViewContainer>

#说明：

感谢[liaohuqiu](https://github.com/liaohuqiu)编写的[cube-sdk](https://github.com/liaohuqiu/cube-sdk)
由于本人开发项目需要上拉加载功能，但不想为了一个下拉刷新将整个cube-sdk引入项目,
于是就移植了[cube-sdk](https://github.com/liaohuqiu/cube-sdk)中loadmore组件。
学习了[cube-sdk](https://github.com/liaohuqiu/cube-sdk)的源码，有很大收获
会尝试实现GridView,RecyclerView等组件的上拉加载功能。  
###欢迎大家[Star](https://github.com/huangliulin/AndroidLoadMore) [Fork](https://github.com/huangliulin/AndroidLoadMore)
