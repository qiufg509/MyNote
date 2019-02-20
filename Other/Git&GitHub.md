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

1、git add 对应的撤销方法git rm --cached

2、关联本地仓库的两种方式

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

