SUMMARY = "This recipe provides RDK HDMICEC HAL Interface headers"
SECTION = "console/utils"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../../../../LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

inherit allarch

SRC_URI = "${RDKE_GITHUB_ROOT}/hdmicec;${RDKE_GITHUB_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git/ccec/include/ccec/driver"
PACKAGE_ARCH = "${MIDDLEWARE_ARCH}"
inherit autotools
ALLOW_EMPTY_${PN} = "1"
