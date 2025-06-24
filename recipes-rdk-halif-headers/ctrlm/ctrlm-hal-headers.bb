# Version and SRCREV for this component is handled in conf/include/rdk-headers-versions.inc

SUMMARY = "This recipe provides RDK Control Manager HAL Interface headers"
SECTION = "console/utils"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

inherit allarch

SRC_URI = "${CMF_GITHUB_ROOT}/control;${CMF_GITHUB_SRC_URI_SUFFIX};name=ctrlm-hal-headers"

S = "${WORKDIR}/git"

# this is a Header package only, nothing to build
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${includedir}/rdk/halif/ctrlm/irdb
    install -m 644 ${S}/src/irdb/ctrlm_irdb_plugin.h ${D}${includedir}/rdk/halif/ctrlm/irdb
}
