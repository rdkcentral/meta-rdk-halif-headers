# meta-rdk-halif-headers
Common meta layer repo created to have the recipes for RDK HAL Interface headers
This meta layer will be shared across middleware layer and vendor layers

Header file repos in this layer are suppoesed to point to rdkcentral github [github.com/rdkcentral], which is the source of truth for RDK HAL Headers

Currently recipes-rdk-halif-headers is having the recipes which are already pointing to rdkcentral github.
recipes-rdk-headers has the recipes for which the header file code is not yet available in the rdkcentral github. These recipes should be reviewed and could be removed in near future.

The version control for the header recipes in done using one inc file "conf/include/rdk-headers-versions.inc" which gets included in the machine config.
