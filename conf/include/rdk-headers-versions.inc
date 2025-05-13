# This inc file contains the versions and SRCREV for individual
# RDK hal header recipes present in rdkcentral/meta-rdk-halif-headers

CMF_GITHUB_ROOT ?= "git://github.com/rdkcentral"
CMF_GITHUB_PROTOCOL ?= "git"
CMF_GITHUB_SRC_URI_SUFFIX ?= "protocol=${CMF_GITHUB_PROTOCOL};nobranch=1"

PV:pn-media-utils-headers = "1.0.5"
PR:pn-media-utils-headers = "r0"
SRCREV:pn-media-utils-headers = "ba963275db7111b78172480fb5142bd04a544026"

PV:pn-hdmicecheader = "1.3.10"
PR:pn-hdmicecheader = "r0"
SRCREV:pn-hdmicecheader = "add261d1f77ffb50d38fb7e100450aabcfbd73e7"

PV:pn-deepsleep-manager-headers = "1.0.4"
PR:pn-deepsleep-manager-headers = "r0"
SRCREV:pn-deepsleep-manager-headers = "cb361e50aedbbce1d5da2dbb86e698c95a2d5648"

PV:pn-power-manager-headers = "1.0.3"
PR:pn-power-manager-headers = "r0"
SRCREV:pn-power-manager-headers = "d54d79097cd48e362fd7a8c7bc41ccba7839e718"

PV:pn-devicesettings-hal-headers = "5.1.0"
PR:pn-devicesettings-hal-headers = "r0"
SRCREV:pn-devicesettings-hal-headers = "9d2303c5e986e586905f2e6026d27ebdee5fead9"

PV:pn-tvsettings-hal-headers = "2.2.7"
PR:pn-tvsettings-hal-headers = "r0"
SRCREV:pn-tvsettings-hal-headers ="b8619ddd5e63f815daef8bd33e8cc29a84d7b3bf"

PV:pn-iarmmgrs-hal-headers = "1.0.12"
PR:pn-iarmmgrs-hal-headers = "r0"
SRCREV:pn-iarmmgrs-hal-headers = "2ec0b6f6caa662f86963e58c417e8e54e221c99b"

PV:pn-iarmbus-headers = "1.0.1"
PR:pn-iarmbus-headers = "r0"
SRCREV:pn-iarmbus-headers = "6ed35ebb886a8ac01812d8bfe5b4c3a89f9ace38"

PV:pn-rdk-gstreamer-utils-headers = "1.0.0"
PR:pn-rdk-gstreamer-utils-headers = "r0"
SRCREV:pn-rdk-gstreamer-utils-headers = "ceb1e846dc1c959dae401db6036bd133fecc9d52"
