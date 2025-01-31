# Version and SRCREV for this component is handled in conf/include/rdk-headers-versions.inc

SUMMARY = "TVsettings HAL headers"
SECTION = "console/utils"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

inherit allarch
SRC_URI = "${CMF_GITHUB_ROOT}/rdkv-halif-tvsettings;${CMF_GITHUB_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

# this is a HAL package only, nothing to build
do_compile[noexec] = "1"
do_configure[noexec] = "1"

# also get rid of the default dependency added in bitbake.conf
# since there is no 'main' package generated (empty)
RDEPENDS_${PN}-dev = ""
# to include the headers in the SDK
ALLOW_EMPTY_${PN} = "1"

do_install() {
    install -d ${D}${includedir}/rdk/tv-hal
    install -m 0644 ${S}/include/*.h ${D}${includedir}/rdk/tv-hal
}

