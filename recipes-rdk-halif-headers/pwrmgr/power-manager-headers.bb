# Version and SRCREV for this component is handled in conf/include/rdk-headers-versions.inc

SUMMARY = "This recipe provides RDK Power Manager HAL Interface headers"
SECTION = "console/utils"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

inherit allarch

SRC_URI = "${CMF_GITHUB_ROOT}/rdk-halif-power_manager;${CMF_GITHUB_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

# this is a Header package only, nothing to build
do_compile[noexec] = "1"
do_configure[noexec] = "1"


do_install() {
        install -d ${D}${includedir}/rdk/iarmmgrs-hal
        install -m 0644 ${S}/include/*.h ${D}${includedir}/rdk/iarmmgrs-hal
}

