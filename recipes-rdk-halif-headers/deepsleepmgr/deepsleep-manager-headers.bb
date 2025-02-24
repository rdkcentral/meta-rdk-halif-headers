# Version and SRCREV for this component is handled in conf/include/rdk-headers-versions.inc

SUMMARY = "This recipe provides RDK Deepslee Manager HAL Interface headers"
SECTION = "console/utils"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

inherit allarch

SRC_URI = "${CMF_GITHUB_ROOT}/rdk-halif-deepsleep_manager;${CMF_GITHUB_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

# this is a Header package only, nothing to build
do_compile[noexec] = "1"
do_configure[noexec] = "1"


do_install() {
        install -d ${D}${includedir}/rdk/halif/deepsleep-manager
        install -m 0644 ${S}/include/*.h ${D}${includedir}/rdk/halif/deepsleep-manager
}
