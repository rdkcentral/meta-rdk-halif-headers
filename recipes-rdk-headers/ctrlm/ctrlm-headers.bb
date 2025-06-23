# Version and SRCREV for this component is handled in conf/include/rdk-headers-versions.inc

SUMMARY = "Control Manager Headers"
SECTION = "console/utils"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

ALLOW_EMPTY:${PN} = "1"

SRC_URI = "${CMF_GITHUB_ROOT}/control;${CMF_GITHUB_SRC_URI_SUFFIX};name=ctrlm-headers"

S = "${WORKDIR}/git"

inherit allarch

# this is a HAL package only, nothing to build
do_compile[noexec] = "1"
do_configure[noexec] = "1"

# also get rid of the default dependency added in bitbake.conf
# since there is no 'main' package generated (empty)
RDEPENDS:${PN}-dev = ""

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${includedir}
    install -m 644 ${S}/include/ctrlm_hal.h       ${D}${includedir}
    install -m 644 ${S}/include/ctrlm_hal_ip.h    ${D}${includedir}
    install -m 644 ${S}/include/ctrlm_hal_ble.h   ${D}${includedir}
    install -m 644 ${S}/include/ctrlm_hal_rf4ce.h ${D}${includedir}
}
