| java.lang.ClassCastException: android.view.AbsSavedState$1 cannot be cast to android.widget.ProgressBar$SavedState |
| ------------------------------------------------------------ |
| 这个问题折腾了老半天，后来才发现是因为不同布局文件中有重名的控件，而且在要显示的Activity中同时用到了这些布局，所以导致这个问题。 |
| ViewPager中添加的不同Fragment使用的不同布局中的控件不同但id相同，做页面删除刷新时。 |



