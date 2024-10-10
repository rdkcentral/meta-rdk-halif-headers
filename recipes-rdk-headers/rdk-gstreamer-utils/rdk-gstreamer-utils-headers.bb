SUMMARY = "Soc-specific implementations for video applications"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

ALLOW_EMPTY:${PN} = "1"

SRC_URI = "${RDKE_GITHUB_ROOT}/gstreamer-netflix-platform;${RDKE_GITHUB_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"
inherit allarch

# this is a HAL package only, nothing to build
do_compile[noexec] = "1"
do_configure[noexec] = "1"

# also get rid of the default dependency added in bitbake.conf
# since there is no 'main' package generated (empty)
RDEPENDS:${PN}-dev = ""

do_install() {
        install -d ${D}${includedir}
        install -m 0644 ${S}/rdk_gstreamer_utils.h  ${D}${includedir}/
        install -m 0644 ${S}/rdk_gstreamer_utils_soc.h ${D}${includedir}/
}
