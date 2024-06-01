# Run the app using supervisor

1. Install supervisor
```bash
sudo apt-get update
sudo apt-get install supervisor
```
2. Create a New Supervisor Configuration File
```bash
sudo vi /etc/supervisor/conf.d/carbon-aware-app.conf
```

3. Add the following configuration to the file
```bash
[program:carbon-aware-app]
command=/home/$USER/jdk-21.0.3+9/bin/java -jar /home/$USER/carbon-aware-app-spboot/carbon-aware-0.1.0.jar
directory=/home/$USER/carbon-aware-app-spboot
autostart=true
autorestart=true
startretries=3
user=$USER
redirect_stderr=true
stdout_logfile=/home/$USER/carbon-aware-app-spboot/logs/carbon-aware-app.log
stdout_logfile_maxbytes=1MB
stdout_logfile_backups=10
stderr_logfile=/home/$USER>/carbon-aware-app-spboot/logs/carbon-aware-app.err
stderr_logfile_maxbytes=1MB
stderr_logfile_backups=10
```
Replace `$USER` with your user 

4. Create log directory
```bash
mkdir -p /home/$USER/carbon-aware-app-spboot/logs
chown $USER:$USER /home/$USER/carbon-aware-app-spboot/logs
```

5. Reload Supervisor Configuration
```bash
sudo supervisorctl reread
sudo supervisorctl update
sudo supervisorctl start carbon-aware-app
```
6. Verify the Application is Running
```bash
sudo supervisorctl status carbon-aware-app
```

Also check app logs: `cat /home/$USER/carbon-aware-app-spboot/logs/carbon-aware-app.log
