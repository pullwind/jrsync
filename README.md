jrsync
======

you can download the jrsync-jar to you pc, 

1. need install the java jdk7 or later.
2. need config the ssh.
  on bakcup  pc, terminal:
  ssh-keygen
  cd ~/.ssh
  scp id_rsa.pub root@192.168.0.100:/root/.ssh/id_rsa.pub.1  (which 0.100 is the target server)
  
  on target server :
 cat id_rsa.pub.1 >> authorized_keys
 
 now on the backup pc,  ssh root@192.168.0.100 can login with passwordless.
 
