DESCRIPTION = "U-boot bootloader mxsboot tool"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"
SECTION = "bootloader"
DEPENDS = "openssl"
PROVIDES = "u-boot-mxsboot"

PV = "v2015.07+git${SRCPV}"

SRCREV = "3f0c5353f93b5e9c4d57c9f3886ad4cd78c38a81"
SRCBRANCH = "2015.07+fslc"

SRC_URI = "git://github.com/Freescale/u-boot-fslc.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

EXTRA_OEMAKE = 'HOSTCC="${CC} ${CPPFLAGS}" HOSTLDFLAGS="-L${libdir} -L${base_libdir}" HOSTSTRIP=true CONFIG_MX28=y'

do_configure () {
    oe_runmake sandbox_defconfig
}

do_compile () {
    oe_runmake tools-only
}

do_install () {
    install -d ${D}${bindir}
    install -m 0755 tools/mxsboot ${D}${bindir}/uboot-mxsboot
    ln -sf uboot-mxsboot ${D}${bindir}/mxsboot
}

BBCLASSEXTEND = "native nativesdk"
