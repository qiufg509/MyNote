# Git常用指令

### start a working area (see also: git help tutorial)                              

**clone**      Clone a repository into a new directory                           
**init**       Create an empty Git repository or reinitialize an existing one    



### work on the current change (see also: git help everyday)                        

**add**        Add file contents to the index                                    
**mv**         Move or rename a file, a directory, or a symlink                  
**reset**      Reset current HEAD to the specified state                         
**rm**         Remove files from the working tree and from the index           

  

### examine the history and state (see also: git help revisions)                    

**bisect**     Use binary search to find the commit that introduced a bug        
**grep**       Print lines matching a pattern                                    
**log**        Show commit logs                                                  
**show**       Show various types of objects                                     
**status**     Show the working tree status                                      



### grow, mark and tweak your common history                                        

**branch**     List, create, or delete branches                                  
**checkout**    Switch branches or restore working tree files                    
**commit**     Record changes to the repository                                  
**diff**       Show changes between commits, commit and working tree, etc        
**merge**      Join two or more development histories together                   
**rebase**     Reapply commits on top of another base tip                        
**tag**        Create, list, delete or verify a tag object signed with GPG       



### collaborate (see also: git help workflows)                                      

**fetch**      Download objects and refs from another repository                 
**pull**       Fetch from and integrate with another repository or a local branch
**push**       Update remote refs along with associated objects                  



# Git使用中的一些方法总结

##### 1、编辑但还没add进缓存区的撤销

```
git checkout README.md
```

##### 2、git add 对应的撤销方法

```
git rm --cached
```

##### 3、git commit 对应的撤销方法

```
#--hard删除本地修改内容彻底回到上一个版本，不带任何参数则回退到上一个版本同时保留更改的数据
#HEAD^ 表示上一个不版本，可替换为具体的版本哈希码使数据回滚到该版本上
git reset [--hard] HEAD^
```

##### 4、恢复到以及被删除了的版本

```
git reflog #可以查看所有分支的所有操作记录（包括已经被删除的 commit 记录和 reset 的操作）
git reset --hard 被删除的版本的哈希码
```

##### 5、关联本地仓库的两种方式

```
#有远程仓库直接clone到本地
git clone git@github.com:qiufg509/MyNote.git
```

```
#本地有完整数据要提交到远程服务器

远程服务器——创建空白仓库（已有仓库则省略该步骤）
本地数据根目录——
git init
git add .
git commit -m "如果已经是完整的Git仓库则省略6\7\8步骤"
git remote add origin git@github.com:qiufg509/MyNote.git
git pull --allow-unrelated-histories origin master
(步骤10有冲突处理：按"Esc",输入":wq",回车)
git push origin master
或不执行步骤9\10则执行13强制提交 
git push -u origin master -f
```

##### 6、Git日志

1、格式化日志，使用自定义指令git lg

```
git config --global alias.lg "log --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit --date=relative"
```

2、常用的git log参数

```
--author="xxx" #按用户xxx过滤的日志
--grep="xxx" #按commit描述过滤日志
./Android/常用快捷键.md #按文件过滤日志
--pretty=oneline #一行显示，只显示哈希值和提交说明
--pretty=format:"" #控制显示的记录格式
```

##### 7、Git查看差异

```
git diff <$id1> <$id2> # 比较两次提交之间的差异
git diff <branch1>..<branch2> # 在两个分支之间比较
git diff --staged # 比较暂存区和版本库差异
```

##### 8、将数据存入缓存区，做其他操作（切换分支修改BUG等），再还原

```
git stash
做其他操作...切换回原来分支
git stash pop
```

##### 9、分支的常用操作

```
#创建并切换分支，相当于执行创建分支git branch develop 和git checkout develop
git checkout -b develop
#本地没有远程有，创建并切换到远程指定的分支
git checkout --track origin/develop
#删除本地分支
git branch -d develop
git branch -D develop (强制删除)
#删除远程分支
git push origin :develop
```

##### 10、修改最近commit的message（还没有push到远程服务器）

```
git commit --amend
#按i修改message，输输入“:wq”回车完成修改
```



# repo

##### 下载repo并克隆manifest

```
repo init -u git@192.168.0.105:AndroidApp/HampooHome/manifest.git -m sk11.xml --repo-url=git@192.168.0.105:AndroidApp/HampooHome/repo.git --no-repo-verify --repo-branch=master
```

##### 下载代码

```
repo sync 
```

##### 查看分支

```
repo branches
```

##### 创建并切换分支

```
repo start developer --all
```

##### 删除分支

```
repo abandon developer
```

##### 切换分支

```
repo checkout
```

##### 遍历执行所有仓库的git指令

```
repo forall -c git pull origin developer
```

