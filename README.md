# testtask
Create java application that will: Take as a command line parameter an URL http://evviva-adk.info/v/file_list.txt  
Download this file to memory. 
File contains comma-separated list of links to download and its md5 checksum Download all files in parallel Check md5 checksum of every downloaded file and output it together with the value, taken from file_list.txt like:  
Downloaded file: &lt;file_name>, expected md5: &lt;md5>, received md5: &lt;md5> Example output: Downloaded file: file1.7z, expected md5: 28fd486ed08c40d75bcdd6b749348692, received md5: 28fd486ed08c40d75bcdd6b749348692 

Required restrictions: 
Java 8 Application must be configured to consume not more, than 200Mb of memory


