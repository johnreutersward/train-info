train-info
==========

Retrieve information of arriving and departing trains at any train station in Sweden.  
train-info can also be used to retrieve information of a train according to it's number. 
Most of the output is in Swedish.

Instructions
------------
1. git clone git://github.com/rojters/train-info.git
2. ant compile
3. ant jar

* ./train-info "Stockholm C"
OR
* ./train-info 796

Screenshots
-----------
![Stockholm C](http://dl.dropbox.com/u/6791833/github/train-info_station.png)
![Train 796](http://dl.dropbox.com/u/6791833/github/train-info_train.png)

FAQ
---
* Q: Hold on, how can I be sure to trust this information? What if I miss my train!
* A: The program uses the tåg.info API which in turn uses information available @ Trafikverket (the Swedish Transport Administration) which is the agency responsible for all railway traffic.

