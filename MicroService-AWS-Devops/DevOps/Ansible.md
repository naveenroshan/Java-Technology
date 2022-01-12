---------------------------------------Ansible---------------------------------------------

- Ansible is Configuration management tool
- Work like master Node architecture 
- Ansible Install
```
$ sudo apt update
$ sudo apt install software-properties-common
$ sudo add-apt-repository --yes --update ppa:ansible/ansible
$ sudo apt install python3
$ sudo apt install ansible
```
- Establish SSH between Master and Agent
- Configure hostname and execute remote commands
- Web Server Creation through Master
- Create and Run First PlayBook
- Lopping in action
- Tag Task
- More Tag

```
ansible <group> -m <module>

ansible apache -m ping

---------------------Ad hoc Commands---------------------------------

ansible all -m command -a 'ls'
ansible all -m command -a 'pwd'

ansible agent1 -m  file -a 'path=/root/test.txt state=touch mode=0770 owner=root'
ansible agent1 -m  file -a 'path=/root/test state=directory mode=0770 owner=root'

ansible-doc -l
ansible-doc <module-name>
ansible agent -m setup -u root


-----------------------Install Apache----------------------------------

ansible agent1 -m command -a "apt update"
ansible agent1 -m command -a "apt upgrade"
ansible agent1 -m command -a "apt install apache2"

ansible agent1 -m service -a "name=apache2 state=started"

ansible agent1 -m command -a "apt -y remove apache2"

----------------------Running Play Book------------------------------
ansible-playbook "playbookfilename.yml"

```

